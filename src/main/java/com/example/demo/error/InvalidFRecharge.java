package com.example.demo.error;

public class InvalidFRecharge extends Exception {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidFRecharge(String msg) {
		 super(msg);
	}
	
	public InvalidFRecharge(String msg, Throwable cause) {
		 super(msg, cause);
	}

}
