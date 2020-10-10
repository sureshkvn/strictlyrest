package com.kandula.strictlyrest.spike.web.errors;

import com.kandula.strictlyrest.spike.web.errors.businessexceptions.AccountFrozenException;
import com.kandula.strictlyrest.spike.web.errors.businessexceptions.AccountNotAccessibleException;
import com.kandula.strictlyrest.spike.web.errors.businessexceptions.AccountNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class GlobalAPIErrorHandler {

    @ExceptionHandler(AccountNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public GlobalAPIErrorResponse genericErrorResponse(AccountNotFoundException ex) {
        return new GlobalAPIErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(AccountNotAccessibleException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public GlobalAPIErrorResponse genericErrorResponse(AccountNotAccessibleException ex) {
        return new GlobalAPIErrorResponse(HttpStatus.FORBIDDEN, ex.getMessage());
    }

    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseStatus(HttpStatus.TOO_MANY_REQUESTS)
    public GlobalAPIErrorResponse genericErrorResponse(HttpClientErrorException ex) {
        return new GlobalAPIErrorResponse(HttpStatus.TOO_MANY_REQUESTS, ex.getMessage());
    }

    @ExceptionHandler(AccountFrozenException.class)
    @ResponseStatus(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS)
    public GlobalAPIErrorResponse genericErrorResponse(AccountFrozenException ex) {
        return new GlobalAPIErrorResponse(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS, ex.getMessage());
    }


}
