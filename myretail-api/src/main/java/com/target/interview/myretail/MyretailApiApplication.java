package com.target.interview.myretail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MyretailApiApplication {

	@Bean
	public RestTemplate getRestTemplate() {
		RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
		return restTemplateBuilder.errorHandler(new RestTemplateResponseErrorHandler()).build();

	}

	public static void main(String[] args) {
		SpringApplication.run(MyretailApiApplication.class, args);
	}

}
