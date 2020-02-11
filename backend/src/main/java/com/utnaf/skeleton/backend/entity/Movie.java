package com.utnaf.skeleton.backend.entity;

public class Movie {

    public String title;

    public String tagline;

    public Long released;

    public Movie(String title, String tagline, Long released) {
        this.title = title;
        this.tagline = tagline;
        this.released = released;
    }

    public String getTitle() {
        return title;
    }

    public String getTagline() {
        return tagline;
    }

    public Long getReleased() {
        return released;
    }
}
