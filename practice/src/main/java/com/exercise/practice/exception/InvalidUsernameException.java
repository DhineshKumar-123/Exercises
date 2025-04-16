package com.exercise.practice.exception;

public class InvalidUsernameException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	private String message;
	
	
	public InvalidUsernameException(String message) {
		super();
		this.message = message;
	}


	@Override
	public String getMessage() {
		return message;
	}

}
