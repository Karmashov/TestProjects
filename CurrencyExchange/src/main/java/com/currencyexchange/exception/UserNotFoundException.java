package com.currencyexchange.exception;

public class UserNotFoundException extends RuntimeException {
    private static String message;

    public UserNotFoundException(String message) {
        super(message);
    }

    public static UserNotFoundException create() {
        return new UserNotFoundException(message);
    }
}
