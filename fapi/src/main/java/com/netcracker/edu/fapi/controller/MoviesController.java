package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.dto.MovieListResponse;
import com.netcracker.edu.fapi.models.Movie;
import com.netcracker.edu.fapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/movies")
public class MoviesController {

    @Autowired
    private MovieService movieService;


    /* GET Movies API*/
    /* GET ALL | GET BY ID | GET BY SEARCH QUERY */
    /*--------------------------------*/
    @GetMapping()
    public MovieListResponse get(){
        return movieService.getMovies();
    }

    @PreAuthorize("hasRole('user') or hasRole('admin')")
    @GetMapping("/list")
    public MovieListResponse get(@RequestParam("page") long page, @RequestParam("per") long perPage){
        return movieService.getMoviesWithPagination(page, perPage);
    }
    @PreAuthorize("hasRole('user') or hasRole('admin')")
    @GetMapping("/list/search")
    public MovieListResponse get(@RequestParam("page") long page, @RequestParam("per") long perPage, @RequestParam("query") String query) {
        return movieService.getMoviesWithPaginationAndSearch(page, perPage, query);
    }
    @PreAuthorize("hasRole('user') or hasRole('admin')")
    @GetMapping("/item")
    public ResponseEntity<Movie> get(@RequestParam("id") long id) {
        return movieService.getItem(id);
    }
    @PreAuthorize("hasRole('user') or hasRole('admin')")
    @GetMapping("/search")
    public MovieListResponse getMovieItem(@RequestParam("query") String query) {
        return movieService.search(query);
    }
    /*--------------------------------*/
    /* SAVE Movies API*/
    /* CREATE | UPDATE | DELETE */
    /*--------------------------------*/
    @PreAuthorize("hasRole('user') or hasRole('admin')")
    @PutMapping()
    public ResponseEntity<Boolean> updateMovieItem(@RequestBody Movie movie) {
        return movieService.updateMovie(movie);
    }
    @PreAuthorize("hasRole('user') or hasRole('admin')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> removeMovieItem(@PathVariable long id) {
        return movieService.removeMovie(id);
    }
    /*--------------------------------*/

}
