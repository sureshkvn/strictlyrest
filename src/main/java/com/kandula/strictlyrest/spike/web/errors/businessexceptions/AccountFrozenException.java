package com.kandula.strictlyrest.spike.web.errors.businessexceptions;

public class AccountFrozenException extends RuntimeException {
    public AccountFrozenException(String message) {
        super(message);
    }
}
