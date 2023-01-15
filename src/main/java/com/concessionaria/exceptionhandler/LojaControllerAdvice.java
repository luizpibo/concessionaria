package com.concessionaria.exceptionhandler;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.concessionaria.exceptionhandler.exceptions.lojaController.LojaNotFoundException;

@ControllerAdvice(basePackages = "com.concessionaria.controllers.LojaController")
public class LojaControllerAdvice {
    @ResponseBody
    @ExceptionHandler(LojaNotFoundException.class)
    public ResponseEntity<MessageExceptionHandler> LojaFound(LojaNotFoundException lojaNotFoundException, HttpServletRequest request){
        MessageExceptionHandler error = new MessageExceptionHandler(
                new Date(), HttpStatus.NOT_FOUND.value(), lojaNotFoundException.getMessage(), request.getRequestURI()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
