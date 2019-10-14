package com.stackroute.movieservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//Global Exception

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    //Handling Global Exception
    public ResponseEntity<String> exceptionHandler(Exception e) {
        return new ResponseEntity<>("Global Error : " + e.getMessage(), HttpStatus.CONFLICT);
    }
}

