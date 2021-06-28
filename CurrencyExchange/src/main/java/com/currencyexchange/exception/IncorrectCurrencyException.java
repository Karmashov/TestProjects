package com.currencyexchange.exception;

import com.currencyexchange.dto.Response;

public class IncorrectCurrencyException extends RuntimeException implements Response {

    private static String message = "Не верная валюта";

    public IncorrectCurrencyException(String message) {
        super(message);
    }

    public static IncorrectCurrencyException create() {
        return new IncorrectCurrencyException(message);
    }
}
