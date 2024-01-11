package com.jsp.springboot.MySBApp.exception;

public class StudentNotFoundByIdException extends RuntimeException{
	private String message;
	public StudentNotFoundByIdException(String message) {
		this.message=message;
	}
	@Override
	public String getMessage() {
		return message;
	}
	

}
