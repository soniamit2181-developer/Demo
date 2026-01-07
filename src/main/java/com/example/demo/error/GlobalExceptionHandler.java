package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice 
public class GlobalExceptionHandler {
	// Customer Not Found
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<String> handleError(CustomerNotFoundException ce) {
		return new ResponseEntity<String>(ce.getMessage(), HttpStatus.NOT_FOUND);
		
	}
}
