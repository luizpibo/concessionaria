package com.concessionaria.exceptionhandler.exceptions.userController;


public class EmailExistsException extends RuntimeException {
    public EmailExistsException(String message){
        super(message);
    }
    public EmailExistsException(){
        super("Email already exists");
    }
}
