package com.furkanyesilyurt.springbootex.exception;

public class AddressNotFoundException extends RuntimeException{

    public AddressNotFoundException(String message){
        super(message);
    }
}
