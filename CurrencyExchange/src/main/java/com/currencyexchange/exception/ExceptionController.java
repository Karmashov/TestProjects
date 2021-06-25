package com.currencyexchange.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IncorrectCurrencyException.class)
    public ResponseEntity<?> handleIncorrectCurrencyException(IncorrectCurrencyException ex) {
        CurrencyExceptionHandler handler = new CurrencyExceptionHandler(ex.getMessage());
        return new ResponseEntity<>(handler, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleUserNotFoundException(UserNotFoundException ex) {
        UserExceptionHandler handler = new UserExceptionHandler(ex.getMessage());

        return new ResponseEntity<>(handler, HttpStatus.NOT_FOUND);
    }
}
