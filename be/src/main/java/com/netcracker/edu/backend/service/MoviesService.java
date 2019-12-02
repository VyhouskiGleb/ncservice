package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Movie;

import java.util.List;

public interface MoviesService {
    List<Movie> getAll();
    Movie getById(long id);
    boolean updateMovie(long movieId, Movie movie);
    Movie saveMovie(Movie movie);
    boolean deleteMovie(long id);
    List<Movie> getWithBorders(long start, long end);
    List<Movie> getSearchResult(String query);
}
