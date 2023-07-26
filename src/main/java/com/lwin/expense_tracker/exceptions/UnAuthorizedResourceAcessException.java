package com.lwin.expense_tracker.exceptions;

public class UnAuthorizedResourceAcessException extends Exception {
    public UnAuthorizedResourceAcessException (String message) {
        super(message);
    }
}
