package com.kandula.strictlyrest.spike.web.errors.businessexceptions;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String message) {
        super(message);
    }
}
