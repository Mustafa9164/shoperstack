package com.jsp.prc.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI usersMicroserviceOpenAPI() {

		return new OpenAPI().info(new Info().title("Employee DB").description("Employee management system"))
				.servers(Arrays.asList(new Server().url("localhost:8052").description("local Server"),
						new Server().url("employee Function.com").description("Live Server")));
	}

}


//http://localhost:8052/swagger-ui/index.html#/