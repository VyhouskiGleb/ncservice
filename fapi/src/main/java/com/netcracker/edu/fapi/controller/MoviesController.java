package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.Movie;
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
    @GetMapping("/all/{end}")
    public List<Movie> getAllMovies(@PathVariable int end){
        return movieService.getAll(end);
    }
}
