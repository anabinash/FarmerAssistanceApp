package com.fas.supplier.exceptions;

public class BuyRequestIdNotFoundException extends RuntimeException {
    public BuyRequestIdNotFoundException(String msg) {
        super(msg);
    }
}
