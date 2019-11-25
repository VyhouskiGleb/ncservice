package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Movies;
import com.netcracker.edu.backend.repository.MovieRepository;
import com.netcracker.edu.backend.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MovieServiceImpl implements MoviesService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movies> getAll() {
        List<Movies> tmpList = movieRepository.findAll();
        Collections.reverse(tmpList);
        return tmpList;
    }

    @Override
    public Movies getById(long id) {
        return movieRepository.getOneById(id);
    }

    @Override
    public Movies updateMovie(long movieId, Movies movies) {
        movies.setId(movieId);
        return movieRepository.save(movies);
    }

    @Override
    public Movies saveMovie(Movies movies) {
        return movieRepository.save(movies);
    }

    @Override
    public boolean deleteMovie(long id) {
        movieRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Movies> getWithBorders(long start, long end) {
        List<Movies> tmpMovies = movieRepository.findAll();
        Collections.reverse(tmpMovies);

        List<Movies> resultList = new ArrayList<Movies>();

        try{
            for(long i = start; i < end; i++ ){
                resultList.add(tmpMovies.get((int) i));
            }
        }
        catch(Exception ex){
            System.out.println("LIST PARSE FALTURE");
        }

        return resultList;
    }

    @Override
    public List<Movies> getSearchResult(String query) {
        List<Movies> tmpList = movieRepository.searchMovies(query);
        Collections.reverse(tmpList);
        return tmpList;
    }

}
