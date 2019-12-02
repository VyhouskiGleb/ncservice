package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.Movie;
import org.springframework.http.ResponseEntity;

public interface MovieService {
    ResponseEntity<Movie[]> getMovies();
    ResponseEntity<Movie> getItem(long id);
    ResponseEntity<Movie[]> searchMovies(String query);
    ResponseEntity<Boolean> updateMovie(Movie movie);
    ResponseEntity<Boolean> removeMovie(long id);
}
