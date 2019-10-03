package com.stackroute.movieservice.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Movie {
    @Id
    int movieid;
    String title,genre;
    BigDecimal budget;

    public Movie() {
    }

    public Movie(int id, String title, String genre, BigDecimal budget) {
        this.movieid = id;
        this.title = title;
        this.genre = genre;
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + movieid +
                ", firstname='" + title + '\'' +
                ", lastname='" + genre + '\'' +
                ", age=" + budget +
                '}';
    }

    public int getId() {
        return movieid;
    }

    public void setId(int id) {
        this.movieid = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String firstname) {
        this.title = firstname;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String lastname) {
        this.genre = lastname;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal age) {
        this.budget = age;
    }
}
