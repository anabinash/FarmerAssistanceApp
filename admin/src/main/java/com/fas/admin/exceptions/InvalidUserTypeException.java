package com.fas.admin.exceptions;

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
