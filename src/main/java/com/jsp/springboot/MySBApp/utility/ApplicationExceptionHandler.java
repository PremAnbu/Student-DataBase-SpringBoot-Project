package com.jsp.springboot.MySBApp.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.springboot.MySBApp.exception.StudentNotFoundByIdException;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	@Autowired
	private ErrorStructure<String> structure;
	
	@ExceptionHandler(StudentNotFoundByIdException.class)
	public ResponseEntity<ErrorStructure<String>> handleStudentNotFoundById(StudentNotFoundByIdException exp) {
	    structure.setStstus(HttpStatus.NOT_FOUND.value());
	    structure.setMessage(exp.getMessage());
	    structure.setRootCause("The request user with the give Id is not Found");
		return new ResponseEntity<ErrorStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	
//	@ExceptionHandler
//	public ResponseEntity<String> handleStudentNotFoundById(StudentNotFoundByIdException exp) {
//		String message = exp.getMessage();
//		return new ResponseEntity<String>(message, HttpStatus.NOT_FOUND);
//	}
}
