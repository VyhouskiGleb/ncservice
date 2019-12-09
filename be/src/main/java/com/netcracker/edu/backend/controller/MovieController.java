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
        return movieServices.get();
    }

    @GetMapping("/counter")
    public long getCounter() { return movieServices.getCounter();}

    @GetMapping("/counter/{query}")
    public long getCounter(@PathVariable(name = "query") String query) { return movieServices.getCounter(query);}

    @GetMapping("/{query}")
    public List<Movie> getList(@PathVariable(name = "query") String query) {
        return movieServices.get(query);
    }

    @GetMapping("/{start}/{per}")
    public List<Movie> getList(@PathVariable(name = "start") long start, @PathVariable(name = "per") long per ) {
        return movieServices.get(start, per);
    }

    @GetMapping("/{start}/{per}/search/{searchQuery}")
    public List<Movie> getList(@PathVariable(name = "start") long start, @PathVariable(name = "per") long per, @PathVariable(name = "searchQuery") String query) {
        return movieServices.get(start, per, query);
    }

    @GetMapping("/{id}")
    public Movie getById(@PathVariable(name = "id") long movieId) {
        return movieServices.get(movieId);
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
