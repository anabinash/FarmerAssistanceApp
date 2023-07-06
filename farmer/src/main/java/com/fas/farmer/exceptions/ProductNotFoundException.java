package com.fas.farmer.exceptions;

public class ProductNotFoundException extends  RuntimeException {

    public ProductNotFoundException(String msg){
        super(msg);
    }
}
