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
    public ResponseEntity<?> saveUser(@RequestBody Movie user)
    {
        ResponseEntity responseEntity;
        try{
            movieService.saveUser(user);
            responseEntity = new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
        } catch (Exception e)
        {
            responseEntity= new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("user")
    public ResponseEntity<?> getAllUsers()
    {
        return new ResponseEntity<List<Movie>>(movieService.getAllUsers(),HttpStatus.OK);
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id)
    {
        return new ResponseEntity<Boolean>(movieService.deleteUser(id),HttpStatus.OK);
    }

    //@PatchMapping("users")
    @RequestMapping(method=RequestMethod.PATCH,value="user")
    public ResponseEntity<?> updateUser(@RequestBody Movie user)
    {
        return new ResponseEntity<Movie>(movieService.updateUser(user),HttpStatus.OK);
    }
}
