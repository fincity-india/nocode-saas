package com.fincity.saas.core.service.connection.email;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fincity.nocode.reactor.util.FlatMapUtil;
import com.fincity.saas.commons.security.util.SecurityContextUtil;
import com.fincity.saas.commons.util.LogUtil;
import com.fincity.saas.core.enums.ConnectionSubType;
import com.fincity.saas.core.enums.ConnectionType;
import com.fincity.saas.core.service.ConnectionService;
import com.fincity.saas.core.service.CoreMessageResourceService;
import com.fincity.saas.core.service.TemplateService;

import reactor.core.publisher.Mono;
import reactor.util.context.Context;
import reactor.util.function.Tuples;

@Service
public class EmailService {

	@Autowired
	private ConnectionService connectionService;

	@Autowired
	private CoreMessageResourceService msgService;

	@Autowired
	private SendGridService sendGridService;

	@Autowired
	private SMTPService smtpService;

	@Autowired
	private TemplateService templateService;

	private EnumMap<ConnectionSubType, IAppEmailService> services = new EnumMap<>(ConnectionSubType.class);

	@PostConstruct
	public void init() {

		this.services.put(ConnectionSubType.SENDGRID, sendGridService);
		this.services.put(ConnectionSubType.SMTP, smtpService);
	}

	public Mono<Boolean> sendEmail(String appCode, String clientCode, List<String> addresses, String templateName,
			Map<String, Object> templateData) {
		return this.sendEmail(appCode, clientCode, addresses, templateName, null, templateData);
	}

	public Mono<Boolean> sendEmail(String appCode, String clientCode, List<String> addresses, String templateName,
			String connectionName, Map<String, Object> templateData) {

		return FlatMapUtil.flatMapMono(

				() -> {
					if (appCode != null && clientCode != null)
						return Mono.just(Tuples.of(appCode, clientCode));

					return SecurityContextUtil.getUsersContextAuthentication()
							.map(e -> Tuples.of(e.getUrlAppCode(), e.getClientCode()));
				},

				actup -> connectionService.find(connectionName, actup.getT1(), actup.getT2(), ConnectionType.MAIL)
						.switchIfEmpty(msgService.throwMessage(HttpStatus.NOT_FOUND,
								CoreMessageResourceService.CONNECTION_DETAILS_MISSING, templateName)),

				(actup, conn) -> Mono.justOrEmpty(this.services.get(conn.getConnectionSubType()))
						.switchIfEmpty(msgService.throwMessage(HttpStatus.NOT_FOUND,
								CoreMessageResourceService.CONNECTION_DETAILS_MISSING, conn.getConnectionSubType())),

				(actup, conn, mailService) -> templateService.read(templateName, actup.getT1(), actup.getT2())
						.switchIfEmpty(msgService.throwMessage(HttpStatus.NOT_FOUND,
								CoreMessageResourceService.TEMPLATE_DETAILS_MISSING, templateName)),

				(actup, conn, mailService, template) -> mailService.sendMail(addresses, template, templateData, conn)

		)
				.contextWrite(Context.of(LogUtil.METHOD_NAME, "EmailService.sendEmail"));
	}
}
