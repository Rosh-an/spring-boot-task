package com.stackroute.movieservice.service;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceimpl implements MovieService {

    MovieRepository movieRepository;

    @Autowired
    public MovieServiceimpl(MovieRepository movieRepository)
    {
        this.movieRepository = movieRepository;
    }


    @Override
    public Movie saveUser(Movie user) {
        Movie saveduser= movieRepository.save(user);

        return saveduser;
    }

    @Override
    public List<Movie> getAllUsers() {
        return movieRepository.findAll();
    }

    @Override
    public boolean deleteUser(int id) {
        movieRepository.deleteById(id);
        return true;
    }

    @Override
    public Movie updateUser(Movie user) {
        Movie updateduser= movieRepository.getOne(user.getId());
        updateduser.setTitle(user.getTitle());
        updateduser.setGenre(user.getGenre());
        updateduser.setBudget(user.getBudget());
    //    saveduser.setId(user.getId());
        return movieRepository.save(updateduser);
    }

}
