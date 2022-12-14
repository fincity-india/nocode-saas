package com.fincity.gateway;

import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import org.springframework.stereotype.Service;

import com.fincity.saas.commons.configuration.service.AbstractMessageService;

@Service
public class GatewayMessageResourceService extends AbstractMessageService {

	public static final String OBJECT_NOT_FOUND = "object_not_found";
	public static final String OBJECT_NOT_FOUND_TO_UPDATE = "object_not_found_to_update";
	public static final String FORBIDDEN_CREATE = "forbidden_create";
	public static final String FORBIDDEN_PERMISSION = "forbidden_permission";
	public static final String UNABLE_TO_DELETE = "unable_to_delete";
	public static final String OBJECT_NOT_UPDATABLE = "object_not_updatable";
	public static final String USER_CREDENTIALS_MISMATCHED = "user_credentials_mismatched";
	public static final String UNKNOWN_ERROR = "unknown_error";
	public static final String UNKNOWN_ERROR_WITH_ID = "unknown_error_with_id";
	public static final String UNKONWN_ERROR_INSERT = "unkonwn_error_insert";
	public static final String TOKEN_EXPIRED = "token_expired";
	public static final String UNKNOWN_TOKEN = "unknown_token";
	public static final String ALREADY_EXISTS = "already_exists";

	public GatewayMessageResourceService() {

		super(Map.of(Locale.ENGLISH, ResourceBundle.getBundle("messages", Locale.ENGLISH)));
	}
}