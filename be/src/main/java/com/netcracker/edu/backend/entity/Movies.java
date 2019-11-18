package com.netcracker.edu.backend.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Movies {
    private long id;
    private String mid;
    private String title;
    private String released;
    private String genre;
    private String image;
    private String video;
    private String description;

    @Id
    @Column(name = "m_id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "mdb_id")
    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    @Basic
    @Column(name = "mdb_titile")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "mdb_released")
    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    @Basic
    @Column(name = "mdb_genre")
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Basic
    @Column(name = "mdb_image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "mdb_descr")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movies movies = (Movies) o;
        return id == movies.id &&
                Objects.equals(mid, movies.mid) &&
                Objects.equals(title, movies.title) &&
                Objects.equals(released, movies.released) &&
                Objects.equals(genre, movies.genre) &&
                Objects.equals(description, movies.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mid, title, released, genre, description);
    }
}
