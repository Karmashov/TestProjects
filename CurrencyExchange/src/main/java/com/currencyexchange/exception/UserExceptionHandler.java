package com.currencyexchange.exception;

import lombok.Data;

@Data
public class UserExceptionHandler {
    private final String message;

    public UserExceptionHandler(String message) {
        this.message = message;
    }
}
