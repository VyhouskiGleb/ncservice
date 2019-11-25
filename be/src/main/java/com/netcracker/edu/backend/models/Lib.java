package com.netcracker.edu.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Lib {
    private long id;
    private long userId;
    private Movie movie;
    private long end;
    private boolean status;

    public Lib(long id, long userId, Movie movie, long end, boolean status) {
        this.id = id;
        this.userId = userId;
        this.movie = movie;
        this.end = end;
        this.status = status;
    }

    public Lib() {
        this.userId = 0;
        this.id = 0;
        this.movie = null;
        this.end = 0;
        this.status = false;
    }


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

    public boolean getStatus() {
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
