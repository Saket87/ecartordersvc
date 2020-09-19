package com.ecart.ecartordersvc.exception;


public class BadOrderFormatException  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BadOrderFormatException(String message){
		super(message);
	}

}
