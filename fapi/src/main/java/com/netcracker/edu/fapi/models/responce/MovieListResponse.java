package com.netcracker.edu.fapi.models.responce;

import com.netcracker.edu.fapi.models.Movie;

import java.util.ArrayList;

public class MovieListResponse {
    private boolean status;
    private long counter;
    private Movie[] movies;

    public MovieListResponse(boolean status, long counter, Movie[] movies) {
        this.status = status;
        this.counter = counter;
        this.movies = movies;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public long getCounter() {
        return counter;
    }

    public void setCounter(long counter) {
        this.counter = counter;
    }

    public Movie[] getMovies() {
        return movies;
    }

    public void setMovies(Movie[] movies) {
        this.movies = movies;
    }
}
