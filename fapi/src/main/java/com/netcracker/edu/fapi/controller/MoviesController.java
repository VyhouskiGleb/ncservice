package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.Movie;
import com.netcracker.edu.fapi.models.User;
import com.netcracker.edu.fapi.models.entrydata.AddToLibData;
import com.netcracker.edu.fapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/movies")
public class MoviesController {

    @Autowired
    private MovieService movieService;
    //private UserService userService;

    // todo: @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/get-all")
    public List<Movie> getAllMovies(@RequestParam("end") int end){
        return movieService.getAll(end);
    }

    @GetMapping("/item")
    public Movie getMovieItem(@RequestParam("id") int id) {
        return movieService.getItem(id);
    }

    @GetMapping("/search")
    public List<Movie> getMovieItem(@RequestParam("query") String query) {
        return movieService.searchMovies(query);
    }
//PostMapping
    @RequestMapping(value="/add-to-lib", method = RequestMethod.POST)
    public AddToLibData saveUser(@RequestBody AddToLibData data){
        return movieService.addToLib(data);
    }
}
