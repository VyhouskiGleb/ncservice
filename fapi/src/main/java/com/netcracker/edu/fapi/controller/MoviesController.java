package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.Movie;
import com.netcracker.edu.fapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Movie[]> getAllMovies(){
        return movieService.getMovies();
    }

    @GetMapping("/item")
    public ResponseEntity<Movie> getMovieItem(@RequestParam("id") long id) {
        return movieService.getItem(id);
    }

    @GetMapping("/search")
    public ResponseEntity<Movie[]> getMovieItem(@RequestParam("query") String query) {
        return movieService.searchMovies(query);
    }
    /*--------------------------------*/
    /* SAVE Movies API*/
    /* CREATE | UPDATE | DELETE */
    /*--------------------------------*/
    @PutMapping()
    public ResponseEntity<Boolean> updateMovieItem(@RequestBody Movie movie) {
        return movieService.updateMovie(movie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> removeMovieItem(@PathVariable long id) {
        return movieService.removeMovie(id);
    }
    /*--------------------------------*/

}
