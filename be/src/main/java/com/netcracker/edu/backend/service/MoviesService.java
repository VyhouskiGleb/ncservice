package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Movies;

import java.util.List;

public interface MoviesService {
    List<Movies> getAll();
    Movies getById(int id);
    Movies updateMovie(Movies movie);
    Movies saveMovie(Movies movie);
    boolean deleteMovie(long id);
}
