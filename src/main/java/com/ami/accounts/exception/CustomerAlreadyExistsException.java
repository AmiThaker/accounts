package com.ami.accounts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class CustomerAlreadyExistsException extends RuntimeException{

    private String message;
    
    public CustomerAlreadyExistsException(String message){
        super(message);

    }
}
