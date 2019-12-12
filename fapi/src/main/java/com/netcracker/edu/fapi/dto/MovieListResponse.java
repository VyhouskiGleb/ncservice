package com.netcracker.edu.fapi.dto;

import com.netcracker.edu.fapi.models.Movie;

public class MovieListResponse extends Response{
    private long counter;
    private Movie[] movies;

    public MovieListResponse(boolean status, String message, long counter, Movie[] movies) {
        super(status, message);
        this.counter = counter;
        this.movies = movies;
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
