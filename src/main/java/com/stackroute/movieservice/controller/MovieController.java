package com.stackroute.movieservice.controller;


import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieservice.exceptions.MovieNotFoundException;
import com.stackroute.movieservice.service.MovieService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MovieController {

    MovieService movieService;

    public MovieController(MovieService movieService)
    {
        this.movieService = movieService;
    }

    @PostMapping("movie")
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie)
    {
        ResponseEntity responseEntity;
        try{
            movieService.saveMovie(movie);
            responseEntity = new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
        } catch (MovieAlreadyExistsException e)
        {
            responseEntity= new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("movie")
    public ResponseEntity<?> getAllMovies()
    {
        return new ResponseEntity<List<Movie>>(movieService.getAllMovies(),HttpStatus.OK);

    }

    @DeleteMapping("movie/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id)
    {
        ResponseEntity responseEntity;
        try {
            return new ResponseEntity<Boolean>(movieService.deleteMovie(id), HttpStatus.OK);
        } catch(MovieNotFoundException e)
        {
            responseEntity= new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    //@PatchMapping("users")
    @RequestMapping(method=RequestMethod.PATCH,value="movie")
    public ResponseEntity<?> updateUser(@RequestBody Movie movie)
    {
        return new ResponseEntity<Movie>(movieService.updateMovie(movie),HttpStatus.OK);
    }

    @GetMapping("movie/{title}")
    public ResponseEntity<?> getMovies(@PathVariable("title") String title)
    {
        return new ResponseEntity<List<Movie>>(movieService.getMovies(title),HttpStatus.OK);

    }


}
