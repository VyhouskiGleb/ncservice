package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.dto.MovieListResponse;
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

    private long getCounter() {
        RestTemplate restTemplate = new RestTemplate();
        String counter = restTemplate.getForObject(beServerUrl + "/api/movie/counter", String.class);
        assert counter != null;
        return Long.parseLong(counter);
    }

    private long getCounter(String query) {
        RestTemplate restTemplate = new RestTemplate();
        String counter = restTemplate.getForObject(beServerUrl + "/api/movie/counter/" + query, String.class);
        assert counter != null;
        return Long.parseLong(counter);
    }

    @Override
    public MovieListResponse getMovies() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            Movie[] beRequestResult = restTemplate.getForObject(beServerUrl + "/api/movie", Movie[].class);
            return new MovieListResponse(true, "OK", this.getCounter(), beRequestResult);
        }
        catch (Exception ex) {
            return new MovieListResponse(true, "OK", this.getCounter(), null);
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
    public MovieListResponse search(String query) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            Movie[] beRequestResult = restTemplate.getForObject(beServerUrl+"/api/movie/search/" + query, Movie[].class);
            return new MovieListResponse(true, "OK", this.getCounter(query), beRequestResult);
        }
        catch (Exception ex) {
            System.out.println(ex.toString());
            return new MovieListResponse(false,"", 0, new Movie[0]);
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

    @Override
    public MovieListResponse getMoviesWithPagination(long page, long perPage) {
        try {
            long start = page * perPage;
            RestTemplate restTemplate = new RestTemplate();
            Movie[] beRequestResult = restTemplate.getForObject(beServerUrl + "/api/movie/"+start+"/"+perPage, Movie[].class);
            return new MovieListResponse(true,"", this.getCounter(), beRequestResult);
        }
        catch (Exception ex) {
            return new MovieListResponse(false,"", 0, new Movie[0]);
        }
    }

    @Override
    public MovieListResponse getMoviesWithPaginationAndSearch(long page, long perPage,  String query) {
        try {
            long start = page * perPage;
            RestTemplate restTemplate = new RestTemplate();
            Movie[] beRequestResult = restTemplate.getForObject(beServerUrl + "/api/movie/"+start+"/"+perPage+"/search/"+query, Movie[].class);
            return new MovieListResponse(true,"", this.getCounter(query), beRequestResult);
        }
        catch (Exception ex) {
            return new MovieListResponse(false, "",0, new Movie[0]);
        }
    }
}
