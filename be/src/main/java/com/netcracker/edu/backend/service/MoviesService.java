package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Movie;

import java.util.List;

public interface MoviesService {
    List<Movie> get();
    List<Movie> get(String query);
    List<Movie> get(long start, long end);
    List<Movie> get(long start, long end, String query);
    Movie get(long id);
    long getCounter();
    long getCounter(String query);
    boolean updateMovie(long movieId, Movie movie);
    Movie saveMovie(Movie movie);
    boolean deleteMovie(long id);
}
