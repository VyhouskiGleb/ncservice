package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.dto.MovieListResponse;
import com.netcracker.edu.fapi.models.Movie;
import org.springframework.http.ResponseEntity;

public interface MovieService {
    MovieListResponse getMovies();
    ResponseEntity<Movie> getItem(long id);
    MovieListResponse search(String query);
    ResponseEntity<Boolean> updateMovie(Movie movie);
    ResponseEntity<Boolean> removeMovie(long id);
    MovieListResponse getMoviesWithPagination(long page, long perPage);
    MovieListResponse getMoviesWithPaginationAndSearch(long page, long perPage, String query);
}
