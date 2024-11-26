package com.sprint.boot.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		System.out.println("Welcome.....");
		SpringApplication.run(Application.class, args);
		System.out.println("Welcome Again.....");
	}

	@Bean
	RestTemplate restTemplate() {
		RestTemplate rt = new RestTemplate();
		return rt;
	}
}
