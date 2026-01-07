package com.example.demo.config;

import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Configuration
public class AirportConfig {
	
	@PostConstruct
	public void postMessage() {
		System.out.println("Configuring Airport Config....!!!");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Releasing Airport Config....!!!");
	}

}
