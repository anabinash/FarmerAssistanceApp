package com.fas.supplier.exceptions;

public class NoBuyRequestsFoundException extends RuntimeException {
    public NoBuyRequestsFoundException(String msg) {
        super(msg);
    }
}
