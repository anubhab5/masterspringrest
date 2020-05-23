package com.anubhab.restservices.exceptions;

public class UserAlreadyExistException extends Exception {
 
	private static final long serialVersionUID = -9085685122396184609L;
	
	public UserAlreadyExistException(String message) {
		super(message);
	}

}
