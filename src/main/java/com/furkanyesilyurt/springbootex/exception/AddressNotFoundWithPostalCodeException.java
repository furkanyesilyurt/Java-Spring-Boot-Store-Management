package com.furkanyesilyurt.springbootex.exception;

public class AddressNotFoundWithPostalCodeException extends RuntimeException{

    public AddressNotFoundWithPostalCodeException(String message){
        super(message);
    }
}
