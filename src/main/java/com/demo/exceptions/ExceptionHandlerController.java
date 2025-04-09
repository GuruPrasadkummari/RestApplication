package com.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.demo.Entity.ErrorResponse;

@ControllerAdvice
public class ExceptionHandlerController {
	
	@ExceptionHandler(InvalidCredentialsException.class)
	@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
	public ResponseEntity<ErrorResponse> unauthrize(InvalidCredentialsException exception){
		
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.UNAUTHORIZED.value(), 
				HttpStatus.UNAUTHORIZED.toString(),
				exception.getLocalizedMessage());	
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.UNAUTHORIZED);
	}

}
