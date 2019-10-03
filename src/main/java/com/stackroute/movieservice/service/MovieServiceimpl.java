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
    public Movie saveMovie(Movie movie) {
        Movie savedmovie= movieRepository.save(movie);

        return savedmovie;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public boolean deleteMovie(int id) {
        movieRepository.deleteById(id);
        return true;
    }

    @Override
    public Movie updateMovie(Movie movie) {
        Movie updatedmovie= movieRepository.getOne(movie.getId());
        updatedmovie.setTitle(movie.getTitle());
        updatedmovie.setGenre(movie.getGenre());
        updatedmovie.setBudget(movie.getBudget());
    //    saveduser.setId(user.getId());
        return movieRepository.save(updatedmovie);
    }

}
