package com.stackroute.seeder;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(CommandLineAppStartupRunner.class);

    @Autowired
    MovieRepository movieRepository;
    @Override
    public void run(String... args) throws Exception {
        Movie movie = new Movie(2, "default", "default", BigDecimal.valueOf(0));
        movieRepository.save(movie);
    }
}
