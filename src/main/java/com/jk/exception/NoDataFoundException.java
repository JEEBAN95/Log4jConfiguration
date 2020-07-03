package com.jk.exception;

public class NoDataFoundException extends RuntimeException {

	private static final long serialVersionUID = 6084251517505174478L;

	public NoDataFoundException() {
		
	}

	public NoDataFoundException(String msg) {
		super(msg);
	}
	
	
}
