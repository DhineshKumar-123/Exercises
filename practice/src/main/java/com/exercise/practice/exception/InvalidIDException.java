package com.exercise.practice.exception;

public class InvalidIDException extends RuntimeException
{
	private static final long serialVersionUID = -1426743801567192619L;
	
	private String message;

	public InvalidIDException(String message) {
		super();
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	
	
	
}
