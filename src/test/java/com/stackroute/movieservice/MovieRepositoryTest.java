package com.stackroute.movieservice;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.repository.MovieRepository;
import org.apache.catalina.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MovieRepositoryTest {

    @Autowired
    MovieRepository movieRepository;
    Movie movie;

    @Before
    public void setUp()
    {
        movie = new Movie();
        movie.setBudget(BigDecimal.valueOf(10000));
        movie.setTitle("John");
        movie.setMovieid(101);
        movie.setGenre("Horror");

    }

    @After
    public void tearDown(){

        movieRepository.deleteAll();
    }

    @Test
    public void testSaveMovie(){
        movieRepository.save(movie);
        Movie fetchMovie= movieRepository.findById(movie.getMovieid()).get();
        Assert.assertEquals(101,fetchMovie.getMovieid());
    }

    @Test
    public void testSaveMovieFailure(){
        Movie testMovie = new Movie(1,"Sample","Horror",BigDecimal.valueOf(10000));
        movieRepository.save(movie);
        Movie fetchUser = movieRepository.findById(movie.getMovieid()).get();
        Assert.assertNotSame(testMovie,movie);
    }

    @Test
    public void testUpdateMovie(){
        movieRepository.save(movie);
        Movie movie1= new Movie(101,"Inception","Thriller",BigDecimal.valueOf(1000000));
        Movie updatedmovie= movieRepository.getOne(movie1.getMovieid());
        updatedmovie.setTitle(movie1.getTitle());
        updatedmovie.setGenre(movie1.getGenre());
        updatedmovie.setBudget(movie1.getBudget());
        movieRepository.save(updatedmovie);
        Movie fetchMovie= movieRepository.findById(movie.getMovieid()).get();
        Assert.assertEquals("Inception",fetchMovie.getTitle());
    }

    @Test
    public void testDeleteMovie(){
        Movie m1=new Movie(1,"Bean","Comedy",BigDecimal.valueOf(50000));
        Movie m2=new Movie(2,"Insidious","Horror",BigDecimal.valueOf(20000));
        movieRepository.save(m1);
        movieRepository.save(m2);
        int id=m1.getMovieid();
        movieRepository.deleteById(m1.getMovieid());
        List<Movie> fetchMovieList=movieRepository.findAll();
        Assert.assertEquals(2,fetchMovieList.get(0).getMovieid());
    }

    @Test
    public void testDeleteMovieFailure(){
        Movie m1=new Movie(1,"Bean","Comedy",BigDecimal.valueOf(50000));
        Movie m2=new Movie(2,"Insidious","Horror",BigDecimal.valueOf(20000));
        movieRepository.save(m1);
        movieRepository.save(m2);
        int id=m1.getMovieid();
        movieRepository.deleteById(1);
        List<Movie> fetchMovieList=movieRepository.findAll();
        Assert.assertNotEquals(1,fetchMovieList.get(0).getMovieid());
    }

    @Test
    public void testGetMovies()
    {
        Movie m1=new Movie(1,"Bean","Comedy",BigDecimal.valueOf(50000));
        Movie m2=new Movie(2,"Insidious","Horror",BigDecimal.valueOf(20000));
        movieRepository.save(m1);
        movieRepository.save(m2);
        List list= new ArrayList();
        list = movieRepository.getMovies("Bean");
        Assert.assertEquals(1,list.get(0).);
    }


    @Test
    public void testGetAllMovie(){
        Movie m = new Movie(1,"Sample","Horror",BigDecimal.valueOf(10000));
        Movie m1 = new Movie(2,"Sample2","Comedy",BigDecimal.valueOf(10000));
        movieRepository.save(m);
        movieRepository.save(m1);

        List<Movie> list = movieRepository.findAll();
        Assert.assertEquals("Sample",list.get(0).getTitle());
    }

}
