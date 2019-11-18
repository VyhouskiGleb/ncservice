package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Movies;
import com.netcracker.edu.backend.repository.MovieRepository;
import com.netcracker.edu.backend.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MoviesService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movies> getAll() {
        return (List<Movies>) movieRepository.findAll();
    }

    @Override
    public Movies getById(int id) {
        return movieRepository.getOneById(id);
    }

    @Override
    public Movies updateMovie(Movies movies) {
        return movieRepository.save(movies);
    }

    @Override
    public Movies saveMovie(Movies movies) {
        return movieRepository.save(movies);
    }

    @Override
    public boolean deleteMovie(long id) {
        Long longId = Long.parseLong(String.valueOf(id));
        movieRepository.deleteById(id);
        return true;
    }

}
