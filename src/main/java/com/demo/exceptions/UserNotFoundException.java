package com.demo.exceptions;

public class UserNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 8855826678371294848L;

	public UserNotFoundException(String message) {
		super(message);
	}

}
