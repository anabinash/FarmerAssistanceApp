package com.fas.admin.exceptions;

/**
 * Simple Custom class for Admin Not Logged In
 *
 * @author Praateek Singh
 */
public class AdminNotLoggedInException extends RuntimeException {
    public AdminNotLoggedInException(String msg) {
        super(msg);
    }
}
