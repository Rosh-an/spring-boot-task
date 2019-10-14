package com.stackroute.movieservice.service;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieservice.exceptions.MovieNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
//@Qualifier("dummyclass")
@Profile("dummy")
public class MovieDummyServiceimpl implements MovieService {


    @Override
    public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException { //function to save new movie data
        return null;
    }

    @Override
    public List<Movie> getAllMovies() {
        return null;
    } //function to extract data of all movies

    @Override
    public Movie deleteMovie(int id) throws MovieNotFoundException { //function to delete a certain movie from the database
        return null;
    }

    @Override
    public Movie updateMovie(Movie movie) {
        return null;
    } //function to update movie details

    @Override
    public List<Movie> getMovies(String name) {
        return null;
    } //function to obtain movie data using movie name
}
