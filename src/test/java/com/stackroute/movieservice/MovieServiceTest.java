package com.stackroute.movieservice;


import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieservice.exceptions.MovieNotFoundException;
import com.stackroute.movieservice.repository.MovieRepository;
import com.stackroute.movieservice.service.MovieService;
import com.stackroute.movieservice.service.MovieServiceimpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;

import static javax.print.attribute.TextSyntax.*;
//import static jdk.internal.vm.compiler.word.LocationIdentity.any;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class MovieServiceTest {

    Movie movie;


    @Mock
    MovieRepository movieRepository;


//    MovieService movieService;
    @InjectMocks
    MovieServiceimpl movieServiceimpl;
    List<Movie> list= null;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        movie= new Movie();
        movie.setGenre("Comedy");
        movie.setMovieid(10);
        movie.setTitle("Random");
        movie.setBudget(BigDecimal.valueOf(10000));
        list= new ArrayList<>();
        list.add(movie);
    }

    @Test
    public void saveMovieTestSuccess() throws MovieAlreadyExistsException {

        when(movieRepository.save((Movie) any())).thenReturn(movie);
        Movie savedMovie = movieServiceimpl.saveMovie(movie);
        Assert.assertEquals(movie,savedMovie);

        //verify here verifies that userRepository save method is only called once
        verify(movieRepository,times(1)).save(movie);

    }

    @Test(expected = MovieAlreadyExistsException.class)
    public void saveMovieTestFailure() throws MovieAlreadyExistsException {
        when(movieRepository.save((Movie)any())).thenReturn(null);
        Movie savedMovie = movieServiceimpl.saveMovie(movie);
        System.out.println("savedMovie" + savedMovie);
        //Assert.assertEquals(user,savedUser);

       /*doThrow(new UserAlreadyExistException()).when(userRepository).findById(eq(101));
       userService.saveUser(user);*/


    }

    @Test
    public void updateMovieTestSuccess() throws MovieAlreadyExistsException {

        Movie m1=new Movie(10,"AB","Comedy",BigDecimal.valueOf(2000));
        Movie updatedMovie=null;
        when(movieRepository.save((Movie)any())).thenReturn(movie);
        when(movieRepository.getOne(movie.getMovieid())).thenReturn(movie);
        updatedMovie = movieServiceimpl.updateMovie(m1);
//        when(movieRepository.save(updatedMovie)).thenReturn(updatedMovie);
        Assert.assertEquals(m1,updatedMovie);
        //verify here verifies that userRepository save method is only called once
        verify(movieRepository,times(1)).save(movie);
        verify(movieRepository,times(1)).save(m1);

    }

    @Test
    public void updateMovieTestFailure() throws MovieAlreadyExistsException {

        Movie m1=new Movie(10,"AB","Comedy",BigDecimal.valueOf(2000));
        Movie m2=new Movie(10,"A","Comedy",BigDecimal.valueOf(2000));
        Movie updatedMovie=null;
        when(movieRepository.save((Movie)any())).thenReturn(movie);
        when(movieRepository.getOne(movie.getMovieid())).thenReturn(movie);
        updatedMovie = movieServiceimpl.updateMovie(m1);
//        when(movieRepository.save(updatedMovie)).thenReturn(updatedMovie);
        Assert.assertNotEquals(m2,updatedMovie);
        //verify here verifies that userRepository save method is only called once
        verify(movieRepository,times(1)).save(movie);
        verify(movieRepository,times(1)).save(m1);

    }

    @Test
    public void deleteMovieTestSuccess() throws MovieNotFoundException, MovieAlreadyExistsException {
//        Movie m1=new Movie(10,"AB","Comedy",BigDecimal.valueOf(2000));
        when(movieRepository.save((Movie)any())).thenReturn(movie);
        movieServiceimpl.saveMovie(movie);
        when(movieRepository.existsById(movie.getMovieid())).thenReturn(true);
        Boolean status = movieServiceimpl.deleteMovie(movie.getMovieid());
        Assert.assertEquals(true,status);
        //verify here verifies that userRepository save method is only called once
        verify(movieRepository,times(1)).save(movie);
    }

    @Test(expected = MovieNotFoundException.class)
    public void deleteMovieTestFailure() throws MovieNotFoundException, MovieAlreadyExistsException {
//        Movie m1=new Movie(10,"AB","Comedy",BigDecimal.valueOf(2000));
        when(movieRepository.save((Movie)any())).thenReturn(movie);
        movieServiceimpl.saveMovie(movie);
        when(movieRepository.existsById(movie.getMovieid())).thenReturn(true);
        Boolean status = movieServiceimpl.deleteMovie(1234);
        Assert.assertEquals(true,status);
        //verify here verifies that userRepository save method is only called once
        verify(movieRepository,times(1)).save(movie);
    }


    @Test
    public void getAllMovie(){

        movieRepository.save(movie);
        //stubbing the mock to return specific data
        when(movieRepository.findAll()).thenReturn(list);
        List<Movie> movieList = movieServiceimpl.getAllMovies();
        Assert.assertEquals(list,movieList);
    }





}
