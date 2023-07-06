package com.fas.admin.exceptions;

/**
 * Simple Custom class for User Not Found
 *
 * @author Praateek Singh
 */
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String msg) {
        super(msg);
    }
}
