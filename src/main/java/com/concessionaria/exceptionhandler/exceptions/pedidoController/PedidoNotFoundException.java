package com.concessionaria.exceptionhandler.exceptions.pedidoController;

public class PedidoNotFoundException extends RuntimeException{
    public PedidoNotFoundException (){
        super("Pedido id can't be found.");
    }
    
    public PedidoNotFoundException (String message){
        super(message);
    }
}   
