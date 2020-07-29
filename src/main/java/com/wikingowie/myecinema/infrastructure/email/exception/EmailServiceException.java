package com.wikingowie.myecinema.infrastructure.email.exception;

public class EmailServiceException extends RuntimeException {
    public EmailServiceException(Throwable cause) {
        super(cause);
    }
}
