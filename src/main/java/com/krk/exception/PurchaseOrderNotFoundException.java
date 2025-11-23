package com.krk.exception;

public class PurchaseOrderNotFoundException extends RuntimeException{
	public PurchaseOrderNotFoundException() {
    super();
	}
	public PurchaseOrderNotFoundException(String msg) {
	    super(msg);
		}
	

}
