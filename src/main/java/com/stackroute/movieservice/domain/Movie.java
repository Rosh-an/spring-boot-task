package com.stackroute.movieservice.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Movie {
    @Id
    private int movieid;
    private String title,genre;
    private BigDecimal budget;

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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }
}
