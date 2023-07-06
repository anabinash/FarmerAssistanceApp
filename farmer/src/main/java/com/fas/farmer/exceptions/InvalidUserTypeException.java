package com.fas.farmer.exceptions;

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
