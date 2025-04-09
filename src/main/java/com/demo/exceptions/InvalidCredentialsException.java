package com.demo.exceptions;

public class InvalidCredentialsException extends RuntimeException {

	private static final long serialVersionUID = -330322456332103955L;
	
	public InvalidCredentialsException(String message) {
		super(message);		
	}

}
