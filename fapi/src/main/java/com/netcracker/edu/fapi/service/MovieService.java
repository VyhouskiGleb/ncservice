package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.Movie;
import com.netcracker.edu.fapi.models.entrydata.AddToLibData;
import java.util.List;

public interface MovieService {
    public List<Movie> getAll(int end);
    public Movie getItem(int id);
    public List<Movie> searchMovies(String query);
    public AddToLibData addToLib(AddToLibData data);
}
