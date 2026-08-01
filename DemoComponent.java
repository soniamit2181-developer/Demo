package com.pooja.dev.service;

import org.springframework.stereotype.Component;

@Component
public class DemoComponent {
	
	public String message(String msg) {
		System.out.println("Message....." + msg);
		return msg;
	}

}
