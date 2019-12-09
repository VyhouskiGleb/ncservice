package com.netcracker.edu.fapi.models;
import com.netcracker.edu.fapi.models.Movie;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Lib {
    private long id;
    private long userId;
    private long utcEnd;
    private String status;
    private Movie movie = new Movie();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getUtcEnd() {
        return utcEnd;
    }

    public void setUtcEnd(long utcEnd) {
        this.utcEnd = utcEnd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Lib(long id, long userId, long utcEnd, String status, Movie movie) {
        this.id = id;
        this.userId = userId;
        this.utcEnd = utcEnd;
        this.status = status;
        this.movie = movie;
    }

    public Lib() {
    }

    @Override
    public String toString() {
        return "Lib{" +
                "id=" + id +
                ", userId=" + userId +
                ", utcEnd=" + utcEnd +
                ", status='" + status + '\'' +
                ", movie=" + movie +
                '}';
    }
}
