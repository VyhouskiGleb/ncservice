package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Movies;
import com.netcracker.edu.backend.entity.Users;
import com.netcracker.edu.backend.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieController {
    @Autowired
    private MoviesService movieServices;
    private Object data;

    @RequestMapping(value = "/get-list", method = RequestMethod.GET)
    public List<Movies> getList() {
        return movieServices.getAll();
    }

    @RequestMapping(value = "/get-by-id/{id}", method = RequestMethod.GET)
    public Movies getById(@PathVariable(name = "id") int movieId) {
        return movieServices.getById(movieId);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Movies updateMovie(@RequestBody Movies movie) {
        return movieServices.updateMovie(movie);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Movies saveMovie(@RequestBody Movies movie) {
        return movieServices.saveMovie(movie);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public boolean deleteMovie(@RequestParam long id) {
        return movieServices.deleteMovie(id);
    }

}
