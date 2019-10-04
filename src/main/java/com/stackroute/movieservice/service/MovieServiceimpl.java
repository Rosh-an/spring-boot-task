package com.stackroute.movieservice.service;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieservice.exceptions.MovieNotFoundException;
import com.stackroute.movieservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Primary
@Profile("main")
@Service
@Component
@ConfigurationProperties("application.properties")
public class MovieServiceimpl implements MovieService, ApplicationListener<ApplicationReadyEvent>, CommandLineRunner {

    @Autowired
    Environment environment;

    @Value("${movieid:default}")
    int movieid;
//    @Value("${title:default}")
//    String title;
    @Value("${genre:default}")
    String genre;
    @Value("${budget:default}")
    BigDecimal budget;


    @Autowired
    private MovieRepository movieRepository;

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

    @Override
    public void run(String... args) throws Exception {
//        Movie movie = new Movie(movieid, title, genre, budget);
//        movieRepository.save(movie);
    }


    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Movie movie= new Movie(1,environment.getProperty("title"),genre,budget);
        movieRepository.save(movie);
    }
}
