package com.hillel.multi.configuration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BankManagerNotFoundException extends RuntimeException {

    public BankManagerNotFoundException(String message){
        super(message);
    }
}
