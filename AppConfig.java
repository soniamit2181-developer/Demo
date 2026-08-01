package com.pooja.dev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

@Configuration
public class AppConfig {
	
	@Bean
	public String getConfig() {
		return "Configuration for Spring Boot Application...";
	}
	
	@PostConstruct
	public void postmessage() {
		System.out.println("Welcome to My Spring Boot Application. Enjoy Life!!!");
	}

}
