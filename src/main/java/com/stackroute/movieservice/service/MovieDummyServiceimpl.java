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
    public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException {
        return null;
    }

    @Override
    public List<Movie> getAllMovies() {
        return null;
    }

    @Override
    public boolean deleteMovie(int id) throws MovieNotFoundException {
        return false;
    }

    @Override
    public Movie updateMovie(Movie movie) {
        return null;
    }

    @Override
    public List<Movie> getMovies(String name) {
        return null;
    }
}
