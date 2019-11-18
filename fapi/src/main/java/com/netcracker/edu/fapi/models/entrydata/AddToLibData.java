package com.netcracker.edu.fapi.models.entrydata;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class AddToLibData {
    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public long getOrderTime() {
        return orderTime;
    }

    @Override
    public String toString() {
        return "AddToLibData{" +
                "movieId=" + movieId +
                ", orderTime=" + orderTime +
                '}';
    }

    public void setOrderTime(long orderTime) {
        this.orderTime = orderTime;
    }

    private long movieId;
    private long orderTime;
}
