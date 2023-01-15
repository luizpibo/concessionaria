package com.concessionaria.exceptionhandler.exceptions.lojaController;


public class LojaNotFoundException extends RuntimeException{
    public LojaNotFoundException (){
        super("Loja id can't be found.");
    }
    
    public LojaNotFoundException (String message){
        super(message);
    }
}   
