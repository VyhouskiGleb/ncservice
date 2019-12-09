package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.Movie;
import com.netcracker.edu.fapi.models.responce.MovieListResponse;
import org.springframework.http.ResponseEntity;

public interface MovieService {
    ResponseEntity<MovieListResponse> getMovies();
    ResponseEntity<Movie> getItem(long id);
    ResponseEntity<MovieListResponse> search(String query);
    ResponseEntity<Boolean> updateMovie(Movie movie);
    ResponseEntity<Boolean> removeMovie(long id);
    ResponseEntity<MovieListResponse> getMoviesWithPagination(long page, long perPage);
    ResponseEntity<MovieListResponse> getMoviesWithPaginationAndSearch(long page, long perPage, String query);
}
