package com.stackroute.movieservice.service;

import com.stackroute.movieservice.domain.Movie;


import java.util.List;

public interface MovieService {

    public Movie saveUser(Movie user);
    public List<Movie> getAllUsers();
    public boolean deleteUser(int id);
    public Movie updateUser(Movie user);


}
