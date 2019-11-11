package com.netcracker.edu.fapi.models;
import com.netcracker.edu.fapi.models.Movie;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Lib {
    private long id;
    private Movie movie;
    private long end;
    private boolean status;

    public Lib(long id, Movie movie, long end, boolean status) {
        this.id = id;
        this.movie = movie;
        this.end = end;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Lib{" +
                "id=" + id +
                ", movie=" + movie +
                ", end=" + end +
                ", status=" + status +
                '}';
    }
}
