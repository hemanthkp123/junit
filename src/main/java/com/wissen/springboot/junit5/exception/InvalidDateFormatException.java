package com.wissen.springboot.junit5.exception;

import org.springframework.http.HttpStatus;

public class InvalidDateFormatException extends RuntimeException {
	HttpStatus code;

	public InvalidDateFormatException(HttpStatus code) {
		super();
		this.code = code;
	}

	public InvalidDateFormatException(String message, Throwable cause, HttpStatus code) {
		super(message, cause);
		this.code = code;
	}

	public InvalidDateFormatException(String message, HttpStatus code) {
		super(message);
		this.code = code;
	}

	public InvalidDateFormatException(Throwable cause, HttpStatus code) {
		super(cause);
		this.code = code;
	}

	public HttpStatus getCode() {
		return this.code;
	}
}
