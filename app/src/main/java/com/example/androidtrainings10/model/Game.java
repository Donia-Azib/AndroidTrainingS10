package com.example.androidtrainings10.model;

public class Game {
    private String id , reviews_count , name , background_image , rating;

    public Game(String id, String reviews_count, String name, String background_image, String rating) {
        this.id = id;
        this.reviews_count = reviews_count;
        this.name = name;
        this.background_image = background_image;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReviews_count() {
        return reviews_count;
    }

    public void setReviews_count(String reviews_count) {
        this.reviews_count = reviews_count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBackground_image() {
        return background_image;
    }

    public void setBackground_image(String background_image) {
        this.background_image = background_image;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
