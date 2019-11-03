package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.Movie;

import java.util.List;

public interface MovieService {
    public List<Movie> getAll(int end);
}
