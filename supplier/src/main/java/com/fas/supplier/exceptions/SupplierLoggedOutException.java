package com.fas.supplier.exceptions;

public class SupplierLoggedOutException extends RuntimeException {
    public SupplierLoggedOutException(String msg) {
        super(msg);
    }
}
