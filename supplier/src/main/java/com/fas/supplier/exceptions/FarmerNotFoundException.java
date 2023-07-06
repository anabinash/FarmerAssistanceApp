package com.fas.supplier.exceptions;

public class FarmerNotFoundException extends RuntimeException {
    public FarmerNotFoundException(String msg) {
        super(msg);
    }
}
