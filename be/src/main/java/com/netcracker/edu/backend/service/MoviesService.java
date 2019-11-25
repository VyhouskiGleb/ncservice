package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Movies;

import java.util.List;

public interface MoviesService {
    List<Movies> getAll();
    Movies getById(long id);
    Movies updateMovie(long movieId, Movies movie);
    Movies saveMovie(Movies movie);
    boolean deleteMovie(long id);
    List<Movies> getWithBorders(long start, long end);
    List<Movies> getSearchResult(String query);
}
