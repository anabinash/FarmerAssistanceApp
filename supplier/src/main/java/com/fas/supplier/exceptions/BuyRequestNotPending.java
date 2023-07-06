package com.fas.supplier.exceptions;

public class BuyRequestNotPending extends RuntimeException {
    public BuyRequestNotPending(String msg) {
        super(msg);
    }
}
