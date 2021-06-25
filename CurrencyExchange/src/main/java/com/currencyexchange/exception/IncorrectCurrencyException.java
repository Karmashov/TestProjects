package com.currencyexchange.exception;

public class IncorrectCurrencyException extends RuntimeException {

    private static String message;

    public IncorrectCurrencyException(String message) {
        super(message);
    }

    public static IncorrectCurrencyException create() {
        return new IncorrectCurrencyException(message);
    }
}
