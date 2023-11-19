package com.krk.exception;

import java.util.function.Supplier;

public class WhUserTypeNotFound extends RuntimeException {

public WhUserTypeNotFound() {
super();

 }
public WhUserTypeNotFound(String msg) {
super(msg);
}
}
