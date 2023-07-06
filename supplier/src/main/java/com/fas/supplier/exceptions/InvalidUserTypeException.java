package com.fas.supplier.exceptions;

/**
 * Simple Custom class for Invalid User Type Category
 *
 * @author Praateek Singh
 */
public class InvalidUserTypeException extends RuntimeException {
    public InvalidUserTypeException(String msg) {
        super(msg);
    }
}
