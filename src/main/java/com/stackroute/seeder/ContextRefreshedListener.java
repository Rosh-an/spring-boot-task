//package com.stackroute.seeder;
//import com.stackroute.movieservice.domain.Movie;
//import com.stackroute.movieservice.repository.MovieRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.context.event.EventListener;
//import org.springframework.stereotype.Component;
//
//import java.math.BigDecimal;
//import java.util.List;
//
//@Component
//public class ContextRefreshedListener implements ApplicationListener<ApplicationReadyEvent> {
//    public MovieRepository movieRepository;
//
//    @Autowired
//    public void setMovieRepository(MovieRepository movieRepository) {
//        this.movieRepository=movieRepository;
//    }
//
//    @Override
//    public void onApplicationEvent(final ApplicationReadyEvent applicationReadyEvent) {
////        System.out.println("Context Event Received");
////        List<Movie> list=movieRepository.findAll();
////        if(list==null)
////        {
//            Movie movie= new Movie(1,"default","default",BigDecimal.valueOf(0));
//            movieRepository.save(movie);
////        }
//    }
//}