package com.fas.supplier.exceptions;

public class SupplierNotFoundException extends RuntimeException {
    public SupplierNotFoundException(String msg) {
        super(msg);
    }
}
