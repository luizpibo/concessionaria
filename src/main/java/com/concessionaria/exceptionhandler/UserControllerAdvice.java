package com.concessionaria.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@ControllerAdvice(basePackages = "com.concessionaria.controllers.UserController")
public class UserControllerAdvice {

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<MessageExceptionHandler> userNotFound(UserNotFoundException userNotFound, HttpServletRequest request){
        MessageExceptionHandler error = new MessageExceptionHandler(
                new Date(), HttpStatus.NOT_FOUND.value(), userNotFound.getMessage(), request.getRequestURI()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    @ResponseBody
    @ExceptionHandler(UsernameExistsException.class)
    public ResponseEntity<MessageExceptionHandler> usernameExists(UsernameExistsException usernameExists, HttpServletRequest request){
        MessageExceptionHandler error = new MessageExceptionHandler(
                new Date(), HttpStatus.IM_USED.value(), usernameExists.getMessage(), request.getRequestURI()
        );
        return new ResponseEntity<>(error, HttpStatus.IM_USED);
    }
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MessageExceptionHandler> argumentsNotValid(MethodArgumentNotValidException notValid, HttpServletRequest request){

        BindingResult result = notValid.getBindingResult();
        List<FieldError> fieldErrorList = result.getFieldErrors();

        StringBuilder sb = new StringBuilder("The following fields cannot be null: ");
        for(FieldError fieldError: fieldErrorList){
            sb.append(" | ");
            sb.append(" -> ");
            sb.append(fieldError.getField());
            sb.append(" <- ");
        }
        MessageExceptionHandler error = new MessageExceptionHandler(
                new Date(), HttpStatus.BAD_REQUEST.value(), sb.toString(), request.getRequestURI()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
