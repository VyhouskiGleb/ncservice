package com.netcracker.edu.backend.entity;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="users_orders")
public class Order {
    private long id;
    private long userId;
    private long utcEnd;
    private String status;
    private Movie movie = new Movie();
    @OneToOne(targetEntity=Movie.class, fetch=FetchType.EAGER)
    @JoinColumn(name="m_id")
    public Movie getMovie() {
        return movie;
    }
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id")
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
        Order order = (Order) o;
        return id == order.id &&
                Objects.equals(movie, order.movie) &&
                Objects.equals(userId, order.userId) &&
                Objects.equals(utcEnd, order.utcEnd) &&
                Objects.equals(status, order.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, movie, userId, utcEnd, status);
    }
}
