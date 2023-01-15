package com.concessionaria.exceptionhandler.exceptions.userController;

public class UsernameExistsException extends RuntimeException {
    public UsernameExistsException(String message) {
        super(message);
    }

    public UsernameExistsException() {
        super("Username already exists");
    }
}
