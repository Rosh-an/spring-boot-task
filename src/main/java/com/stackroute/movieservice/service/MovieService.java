package com.stackroute.movieservice.service;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieservice.exceptions.MovieNotFoundException;


import java.util.List;

public interface MovieService {

    public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException; //function to save new movie data
    public List<Movie> getAllMovies() throws MovieNotFoundException; //function to extract data of all movies
    public Movie deleteMovie(int id) throws MovieNotFoundException; //function to delete a certain movie from the database
    public Movie updateMovie(Movie movie) throws MovieNotFoundException; //function to update movie details
    public List<Movie> getMovies(String name) throws MovieNotFoundException; //function to obtain movie data using movie name


}
