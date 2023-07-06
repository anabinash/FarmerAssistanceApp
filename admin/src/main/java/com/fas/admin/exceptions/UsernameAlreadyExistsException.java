package com.fas.admin.exceptions;

public class UsernameAlreadyExistsException extends RuntimeException {
    public UsernameAlreadyExistsException(String msg) {
        super(msg);
    }
}
