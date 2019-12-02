package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Movie;
import com.netcracker.edu.backend.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieController {
    @Autowired
    private MoviesService movieServices;

    @GetMapping()
    public List<Movie> getList() {
        return movieServices.getAll();
    }

    @GetMapping("/{start}/{end}")
    public List<Movie> getListBordered(@PathVariable(name = "start") long start, @PathVariable(name = "end") long end ) {
        return movieServices.getWithBorders(start,end);
    }

    @GetMapping("/search/{searchQuery}")
    public List<Movie> getListBordered(@PathVariable(name = "searchQuery") String query) {
        return movieServices.getSearchResult(query);
    }

    @GetMapping("/{id}")
    public Movie getById(@PathVariable(name = "id") long movieId) {
        return movieServices.getById(movieId);
    }

    @PutMapping(value = "/{id}")
    public boolean updateMovie(@RequestBody Movie movie, @PathVariable(name = "id") long movieId) {
        return movieServices.updateMovie( movieId, movie);
    }

    @PostMapping()
    public Movie saveMovie(@RequestBody Movie movie) {
        return movieServices.saveMovie(movie);
    }

    @DeleteMapping("/{id}")
    public boolean deleteMovie(@PathVariable(name = "id") long id) {
        return movieServices.deleteMovie(id);
    }

}
