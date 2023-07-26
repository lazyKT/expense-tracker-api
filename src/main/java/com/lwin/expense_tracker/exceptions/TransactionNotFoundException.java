package com.lwin.expense_tracker.exceptions;

public class TransactionNotFoundException extends Exception {
    public TransactionNotFoundException (String message) {
        super(message);
    }
}
