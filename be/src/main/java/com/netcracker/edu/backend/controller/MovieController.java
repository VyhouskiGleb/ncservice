package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Movies;
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
    public List<Movies> getList() {
        return movieServices.getAll();
    }

    @GetMapping("/{start}/{end}")
    public List<Movies> getListBordered(@PathVariable(name = "start") long start, @PathVariable(name = "end") long end ) {
        return movieServices.getWithBorders(start,end);
    }

    @GetMapping("/search/{searchQuery}")
    public List<Movies> getListBordered(@PathVariable(name = "searchQuery") String query) {
        return movieServices.getSearchResult(query);
    }

    @GetMapping("/{id}")
    public Movies getById(@PathVariable(name = "id") long movieId) {
        return movieServices.getById(movieId);
    }

    @PutMapping(value = "/{id}")
    public Movies updateMovie(@RequestBody Movies movie, @PathVariable(name = "id") long movieId) {
        return movieServices.updateMovie( movieId, movie);
    }

    @PostMapping()
    public Movies saveMovie(@RequestBody Movies movie) {
        return movieServices.saveMovie(movie);
    }

    @DeleteMapping("/{id}")
    public boolean deleteMovie(@PathVariable(name = "id") long id) {
        return movieServices.deleteMovie(id);
    }

}
