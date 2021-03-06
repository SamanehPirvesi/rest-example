package com.example.test.exception;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandlers{
	
	@ExceptionHandler(value=UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleMyException(Exception ex, HttpServletRequest reuest) {	
	ErrorResponse error= new ErrorResponse(ex.getMessage(),reuest.getRequestURI(),HttpStatus.NOT_FOUND.value(),new Timestamp(System.currentTimeMillis()).toString());
		return new ResponseEntity<ErrorResponse>(error,HttpStatus.NOT_FOUND);		
	}
	@ExceptionHandler(value=RuntimeException.class)
	public ResponseEntity<String> handleMyException(Exception ex) {			
		return new ResponseEntity<String>("Some error has happend",HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}