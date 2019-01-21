package com.rami.netflux.domain;

import java.util.Date;

public class MovieEvent {

    private String movieId;

    private Date date;


    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
