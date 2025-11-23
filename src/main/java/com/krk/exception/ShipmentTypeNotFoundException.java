package com.krk.exception;

public class ShipmentTypeNotFoundException extends RuntimeException {
 public ShipmentTypeNotFoundException() {
 super();
 }
 public ShipmentTypeNotFoundException(String msg) {
	 super(msg);
 }
}
