package com.fincity.saas.core.configuration;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.FormHttpMessageConverter;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import reactivefeign.spring.config.EnableReactiveFeignClients;

@Configuration
@EnableReactiveFeignClients
public class FileFeignConfiguration {

	@Bean
	Encoder feignFormEncoder() {

		FormHttpMessageConverter formHttpMessageConverter = new FormHttpMessageConverter();

		HttpMessageConverters converters = new HttpMessageConverters(formHttpMessageConverter);

		return new SpringFormEncoder(new SpringEncoder(() -> converters));
	}
}
