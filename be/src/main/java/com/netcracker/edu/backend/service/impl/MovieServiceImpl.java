package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Movie;
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
    public List<Movie> get() {
        return movieRepository.findAll();
    }
    @Override
    public List<Movie> get(String query) {
        return movieRepository.findAll(query);
    }
    @Override
    public List<Movie> get(long start, long num) { return movieRepository.findAll(start, num); }
    @Override
    public List<Movie> get(long start, long num, String query) {
        return movieRepository.findAll(start, num, query);
    }
    @Override
    public Movie get(long id) {
        return movieRepository.getOneById(id);
    }

    @Override
    public boolean updateMovie(long movieId, Movie movie) {
        try {
            Movie tmpMovie = get(movieId);
            if (movie.getTitle() == null) movie.setTitle(tmpMovie.getTitle());
            if (movie.getDescription() == null) movie.setDescription(tmpMovie.getDescription());
            if (movie.getMid() == null) movie.setMid(tmpMovie.getMid());
            if (movie.getImage() == null) movie.setImage(tmpMovie.getImage());
            if (movie.getReleased() == null) movie.setReleased(tmpMovie.getReleased());
            if (movie.getVideo() == null) movie.setVideo(tmpMovie.getVideo());
            movie.setId(movieId);
            Movie result = movieRepository.save(movie);
            boolean resultVal = true;
            if(result == null) resultVal = false;
            return resultVal;
        }
        catch (Exception ex) {
            return false;
        }
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public boolean deleteMovie(long id) {
        movieRepository.deleteById(id);
        return true;
    }

    @Override
    public long getCounter() {
        return movieRepository.count();
    }

    @Override
    public long getCounter(String query) {
        return movieRepository.count(query);
    }

}
