package com.retailstore.order.exception;

public class BadDataException extends RuntimeException {
    public BadDataException(String s) {
        super(s);
    }
}
