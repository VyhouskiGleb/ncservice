package com.netcracker.edu.backend.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Orders {
    private long id;
    private long movieId;
    private long userId;
    private long utcEnd;
    private String status;

    @Id
    @Column(name = "order_id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "m_id")
    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    @Basic
    @Column(name = "order_user_id")
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "order_utc_end")
    public long getUtcEnd() {
        return utcEnd;
    }

    public void setUtcEnd(long utcEnd) {
        this.utcEnd = utcEnd;
    }

    @Basic
    @Column(name = "order_status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders order = (Orders) o;
        return id == order.id &&
                Objects.equals(movieId, order.movieId) &&
                Objects.equals(userId, order.userId) &&
                Objects.equals(utcEnd, order.utcEnd) &&
                Objects.equals(status, order.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, movieId, userId, utcEnd, status);
    }
}
