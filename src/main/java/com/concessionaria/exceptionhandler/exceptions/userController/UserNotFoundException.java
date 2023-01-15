package com.concessionaria.exceptionhandler.exceptions.userController;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException() {
        super("User can't be found");
    }
}
