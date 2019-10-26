package com.lpdev.salesmanagement.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	@Bean
	public Validator getValidator() {
		return new Validator();
	}

	@Bean
	public Result getResult() {
		return new Result();
	}
}
