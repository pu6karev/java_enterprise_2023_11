package com.hillel.multi.controller.configuration.handler;

import com.hillel.multi.configuration.exception.BankManagerException;
import com.hillel.multi.configuration.exception.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(BankManagerException.class)
    public ResponseEntity<ErrorDetails> handleAllException(Exception ex) {

        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage(ex.getMessage());

        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}