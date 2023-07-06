package com.fas.farmer.exceptions;

public class FarmerLoggedOutException extends RuntimeException {
    public FarmerLoggedOutException(String msg) {
        super(msg);
    }
}
