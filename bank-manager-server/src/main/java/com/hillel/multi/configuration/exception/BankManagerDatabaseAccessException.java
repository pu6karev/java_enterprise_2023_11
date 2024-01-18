package com.hillel.multi.configuration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class BankManagerDatabaseAccessException extends RuntimeException{

    public BankManagerDatabaseAccessException(String message){
        super(message);
    }

}
