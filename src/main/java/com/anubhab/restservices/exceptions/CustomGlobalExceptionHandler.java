package com.anubhab.restservices.exceptions;

import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	// Method Argument Not Valid Exception
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		CustomErrorDetails custErrDetails = new CustomErrorDetails(new Date(), "MethodArgumentNotValidException in GEH",
				ex.getLocalizedMessage());
		return new ResponseEntity<>(custErrDetails, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		CustomErrorDetails custErrDetails = new CustomErrorDetails(new Date(),
				"handleHttpRequestMethodNotSupported NOT ALLOWED", ex.getLocalizedMessage());
		return new ResponseEntity<>(custErrDetails, HttpStatus.METHOD_NOT_ALLOWED);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNameNotFound(UserNotFoundException ex, WebRequest request) {

		CustomErrorDetails custErrDetails = new CustomErrorDetails(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(custErrDetails, HttpStatus.NOT_FOUND);

	}

	// Constraint Violation Exception
	@ExceptionHandler(ConstraintViolationException.class)
	public final ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex,
			 WebRequest request) {
		CustomErrorDetails custErrDetails = new CustomErrorDetails(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(custErrDetails, HttpStatus.BAD_REQUEST);
	}

}
