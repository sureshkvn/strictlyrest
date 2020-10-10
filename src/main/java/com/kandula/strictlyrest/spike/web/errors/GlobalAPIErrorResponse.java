package com.kandula.strictlyrest.spike.web.errors;

import org.springframework.http.HttpStatus;

public class GlobalAPIErrorResponse {

    private HttpStatus statusLineCode;
    private String message;

    @Override
    public String toString() {
        return "GlobalAPIErrorResponse{" +
                "statusLineCode=" + statusLineCode +
                ", message='" + message + '\'' +
                '}';
    }

    public HttpStatus getStatusLineCode() {
        return statusLineCode;
    }

    public void setStatusLineCode(HttpStatus statusLineCode) {
        this.statusLineCode = statusLineCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public GlobalAPIErrorResponse(HttpStatus statusCode, String errorMessage) {
            this.statusLineCode = statusCode;
            this.message = errorMessage;
    }
}
