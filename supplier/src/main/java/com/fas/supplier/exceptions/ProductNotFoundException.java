package com.fas.supplier.exceptions;

public class ProductNotFoundException extends  RuntimeException {

    public ProductNotFoundException(String msg){
        super(msg);
    }
}
