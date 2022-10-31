package com.concessionaria.exceptionhandler;

public class UsernameExistsException extends Exception{
    private String mesage;
    public UsernameExistsException (String mesage){
        this.mesage = mesage;
    }

}
