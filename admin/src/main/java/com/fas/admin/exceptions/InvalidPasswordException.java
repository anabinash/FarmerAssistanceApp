package com.fas.admin.exceptions;

/**
 * Simple Custom class for Invalid Password
 *
 * @author Praateek Singh
 */
public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException(String msg) {
        super(msg);
    }
}
