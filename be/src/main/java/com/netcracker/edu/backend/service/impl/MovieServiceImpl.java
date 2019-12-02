package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Movie;
import com.netcracker.edu.backend.entity.User;
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
    public List<Movie> getAll() {
        List<Movie> tmpList = movieRepository.findAll();
        Collections.reverse(tmpList);
        return tmpList;
    }

    @Override
    public Movie getById(long id) {
        return movieRepository.getOneById(id);
    }

    @Override
    public boolean updateMovie(long movieId, Movie movie) {
        try {
            Movie tmpMovie = getById(movieId);
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
    public List<Movie> getWithBorders(long start, long end) {
        List<Movie> tmpMovies = movieRepository.findAll();
        Collections.reverse(tmpMovies);

        List<Movie> resultList = new ArrayList<Movie>();

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
    public List<Movie> getSearchResult(String query) {
        List<Movie> tmpList = movieRepository.searchMovies(query);
        Collections.reverse(tmpList);
        return tmpList;
    }


}
