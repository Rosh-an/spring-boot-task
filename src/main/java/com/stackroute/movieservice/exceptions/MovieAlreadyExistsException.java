package com.stackroute.movieservice.exceptions;

// Movie Already Exists Exception class
public class MovieAlreadyExistsException extends Exception {
    private String message;
    public MovieAlreadyExistsException(){}
    public MovieAlreadyExistsException(String message){
        super(message);
        this.message=message;
    }
}
