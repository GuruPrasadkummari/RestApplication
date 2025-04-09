package com.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.demo.Entity.UserException;

@ControllerAdvice
public class UserExceptionHandler {	
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<UserException>userNotFound(UserNotFoundException usernotfound)
	{
		UserException userexception= new UserException(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.toString(),
			usernotfound.getMessage());
		
		return new ResponseEntity<UserException>(userexception, HttpStatus.NOT_FOUND);
		
	}

}
