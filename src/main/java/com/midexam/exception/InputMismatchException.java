package com.midexam.exception;

public class InputMismatchException extends Exception {
	
	String msg;
	
	public InputMismatchException(String msg) {
		super();
		this.msg=msg;
	}
}
