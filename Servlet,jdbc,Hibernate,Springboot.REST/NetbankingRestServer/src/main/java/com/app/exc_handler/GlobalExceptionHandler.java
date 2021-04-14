package com.app.exc_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.custom_exceptions.CustomerHandlingException;
import com.app.dto.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(CustomerHandlingException.class)
	public ResponseEntity<?> handleCustomerHandlingException(CustomerHandlingException e) {
		System.out.println("in cust hand exc "+e);
		return new ResponseEntity<>(new ErrorResponse(e.getMessage(), "details"), HttpStatus.UNAUTHORIZED);
	}
}
