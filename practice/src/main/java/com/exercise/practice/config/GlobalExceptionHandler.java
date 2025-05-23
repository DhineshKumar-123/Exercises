package com.exercise.practice.config;

import java.io.IOException;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.exercise.practice.exception.InvalidIDException;
import com.exercise.practice.exception.InvalidUsernameException;

@RestControllerAdvice
public class GlobalExceptionHandler
{

	@ExceptionHandler(InvalidIDException.class)
	public ErrorResponse invalidIDExceptionHandler(InvalidIDException e)
	{
		return ErrorResponse.create(e,HttpStatusCode.valueOf(400),e.getMessage());
	}
	@ExceptionHandler(InvalidUsernameException.class)
	public ErrorResponse invalidUsernameExceptionHandler(InvalidUsernameException e)
	{
		return ErrorResponse.create(e,HttpStatusCode.valueOf(400),e.getMessage());
	}
	@ExceptionHandler(IOException.class)
	public ErrorResponse invalidIOExceptionHandler(IOException e)
	{
		return ErrorResponse.create(e,HttpStatusCode.valueOf(400),e.getMessage());
	}
	@ExceptionHandler(RuntimeException.class)
	public ErrorResponse invalidFileFormatExceptionHandler(RuntimeException e)
	{
		return ErrorResponse.create(e,HttpStatusCode.valueOf(400),e.getMessage());
	}
	@ExceptionHandler(Exception.class)
	 public ErrorResponse exceptionHandler(Exception e) {
		 return ErrorResponse.create
				 			(e, 
				 			HttpStatusCode.valueOf(400), 
				 			e.getMessage()); 
	 }
}
