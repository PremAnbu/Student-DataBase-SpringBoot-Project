package com.jsp.springboot.MySBApp.utility;

import org.springframework.stereotype.Component;

@Component
public class ErrorStructure<T> {
	private int ststus;
	private String message;
	private T rootCause;

	public int getStstus() {
		return ststus;
	}

	public void setStstus(int ststus) {
		this.ststus = ststus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getRootCause() {
		return rootCause;
	}

	public void setRootCause(T rootCause) {
		this.rootCause = rootCause;
	};

}
