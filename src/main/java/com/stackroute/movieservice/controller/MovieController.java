package com.stackroute.movieservice.controller;


import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieservice.exceptions.MovieNotFoundException;
import com.stackroute.movieservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Controller

@RestController
@RequestMapping("/api/v1")
public class MovieController {

    @Autowired
    private MovieService movieService;
    ResponseEntity responseEntity;

    public MovieController(MovieService movieService)
    {
        this.movieService = movieService;
    }

    @PostMapping("movie")
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie)
    {

        try{
            movieService.saveMovie(movie); //saving movie object
            responseEntity = new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
        } catch (MovieAlreadyExistsException e)
        {
            responseEntity= new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT); //catching movie already exists exception
        }
        return responseEntity;
    }

    @GetMapping("movies")
    public ResponseEntity<?> getAllMovies() throws Exception,MovieNotFoundException //throwing global and movie not found exception
    {
        return new ResponseEntity<List<Movie>>(movieService.getAllMovies(),HttpStatus.OK); //getting all movies data

    }

    @DeleteMapping("movie/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id) throws MovieNotFoundException
    {

            return new ResponseEntity<Movie>(movieService.deleteMovie(id), HttpStatus.OK); //deleting movie data by id
    }

    //@PatchMapping("users")
    @RequestMapping(method=RequestMethod.PUT,value="movie")
    public ResponseEntity<?> updateUser(@RequestBody Movie movie) throws MovieNotFoundException {
        return new ResponseEntity<Movie>(movieService.updateMovie(movie),HttpStatus.OK); //updating movie data
    }

    @GetMapping("movie/{title}")
    public ResponseEntity<?> getMovies(@PathVariable("title") String title) throws MovieNotFoundException {
        return new ResponseEntity<List<Movie>>(movieService.getMovies(title),HttpStatus.OK); //getting movie data by name

    }

}
