package com.lwin.expense_tracker.exceptions;

public class UserAlreadyExistedException extends Exception {
    public UserAlreadyExistedException (String message) {
        super(message);
    }
}
