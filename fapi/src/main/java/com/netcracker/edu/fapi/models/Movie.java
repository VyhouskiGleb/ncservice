package com.netcracker.edu.fapi.models;

public class Movie {
    private long id;
    private String title;
    private String description;
    private String image;
    private double cost;
    private String video;

    public Movie() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Movie(long id, String title, String description, String image, double cost, String video) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.cost = cost;
        this.video = video;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", cost='" + cost + '\'' +
                ", video='" + video + '\'' +
                '}';
    }
}
