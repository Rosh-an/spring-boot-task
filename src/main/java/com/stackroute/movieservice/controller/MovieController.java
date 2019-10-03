package com.stackroute.movieservice.controller;


import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.service.MovieService;
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

    @PostMapping("user")
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie)
    {
        ResponseEntity responseEntity;
        try{
            movieService.saveMovie(movie);
            responseEntity = new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
        } catch (Exception e)
        {
            responseEntity= new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("user")
    public ResponseEntity<?> getAllMovies()
    {
        return new ResponseEntity<List<Movie>>(movieService.getAllMovies(),HttpStatus.OK);
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id)
    {
        return new ResponseEntity<Boolean>(movieService.deleteMovie(id),HttpStatus.OK);
    }

    //@PatchMapping("users")
    @RequestMapping(method=RequestMethod.PATCH,value="user")
    public ResponseEntity<?> updateUser(@RequestBody Movie movie)
    {
        return new ResponseEntity<Movie>(movieService.updateMovie(movie),HttpStatus.OK);
    }
}
