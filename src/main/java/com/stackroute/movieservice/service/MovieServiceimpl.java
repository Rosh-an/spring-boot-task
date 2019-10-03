package com.stackroute.movieservice.service;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieservice.exceptions.MovieNotFoundException;
import com.stackroute.movieservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
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
    public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException {
        if(movieRepository.existsById(movie.getMovieid()))
        {
            throw new MovieAlreadyExistsException("Movie already exists");
        }
        Movie savedmovie= movieRepository.save(movie);
        if(savedmovie==null)
        {
            throw new MovieAlreadyExistsException("Movie already exits");
        }
        return savedmovie;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public boolean deleteMovie(int id) throws MovieNotFoundException {
        if(!movieRepository.existsById(id))
        {
            throw new MovieNotFoundException("Movie Not Found");
        }
        movieRepository.deleteById(id);
        return true;
    }

    @Override
    public Movie updateMovie(Movie movie) {
        Movie updatedmovie= movieRepository.getOne(movie.getMovieid());
        updatedmovie.setTitle(movie.getTitle());
        updatedmovie.setGenre(movie.getGenre());
        updatedmovie.setBudget(movie.getBudget());
    //    saveduser.setId(user.getId());
        return movieRepository.save(updatedmovie);
    }

    @Override
    public List getMovies(String name)
    {
        return movieRepository.getMovies(name);
    }

}
