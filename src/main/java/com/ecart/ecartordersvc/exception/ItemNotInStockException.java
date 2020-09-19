package com.ecart.ecartordersvc.exception;

public class ItemNotInStockException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ItemNotInStockException(String message){
		super(message);
	}
}
