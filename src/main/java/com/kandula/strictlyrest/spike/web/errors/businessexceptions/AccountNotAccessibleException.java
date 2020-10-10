package com.kandula.strictlyrest.spike.web.errors.businessexceptions;

public class AccountNotAccessibleException extends RuntimeException {
    public AccountNotAccessibleException(String message) {
        super(message);
    }
}
