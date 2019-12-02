package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.Movie;
import com.netcracker.edu.fapi.service.MovieService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("customMovieService")
public class MovieServiceImpl implements MovieService {

    @Value("${nodejs.server.url}")
    private String nodejsServerUrl;

    @Value("${backend.server.url}")
    private String beServerUrl;


    @Override
    public ResponseEntity<Movie[]> getMovies() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            return new ResponseEntity<>(restTemplate.getForObject(beServerUrl + "/api/movie", Movie[].class), HttpStatus.OK);
        }
        catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public ResponseEntity<Movie> getItem(long id) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            Movie result = restTemplate.getForObject(beServerUrl+"/api/movie/"+id, Movie.class);
            ResponseEntity<Movie> entity;
            if(result == null) entity= new ResponseEntity<>(HttpStatus.NO_CONTENT);
            else entity = new ResponseEntity<>(result, HttpStatus.OK);
            return entity;
        }
        catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public ResponseEntity<Movie[]> searchMovies(String query) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            Movie[] result = restTemplate.getForObject(beServerUrl+"/api/movie/search/" + query, Movie[].class);
            ResponseEntity<Movie[]> entity;
            if(result == null) entity= new ResponseEntity<>(HttpStatus.NO_CONTENT);
            else entity = new ResponseEntity<>(result, HttpStatus.OK);
            return entity;
        }
        catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Boolean> updateMovie(Movie movie) {
        try {
            long movieId = movie.getId();
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<Movie> entity = new HttpEntity<Movie>(movie);
            return restTemplate.exchange(beServerUrl+"/api/movie/" + movieId, HttpMethod.PUT, entity, boolean.class);
        }
        catch (Exception ex) {
            return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Boolean> removeMovie(long id) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<Long> entity = new HttpEntity<Long>(id);
            return restTemplate.exchange(beServerUrl+"/api/movie/" + id, HttpMethod.DELETE, entity, boolean.class);
        }
        catch (Exception ex) {
            return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
        }
    }
}
