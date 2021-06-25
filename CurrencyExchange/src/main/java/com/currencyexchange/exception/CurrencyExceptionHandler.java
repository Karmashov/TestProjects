package com.currencyexchange.exception;

import lombok.Data;

@Data
public class CurrencyExceptionHandler {
    private final String message;

    public CurrencyExceptionHandler(String message) {
        this.message = message;
    }
}
