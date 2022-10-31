package com.concessionaria.exceptionhandler;

import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
public class MessageExceptionHandler {
    @NonNull
    private Date timestamp;
    @NonNull
    private Integer status;
    @NonNull
    private String message;
    @NonNull
    private  String path;
}
