package com.stackroute.movieservice.exceptions;

//Movie Not Found Exception class
public class MovieNotFoundException extends Exception {
    private String message;
    public MovieNotFoundException(){}
    public MovieNotFoundException(String message){
        super(message);
        this.message=message;
    }
}
