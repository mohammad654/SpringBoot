package com.appiekap.movietheater.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Movie() {
    }

    public Movie(long id, String title, boolean watched) {
        this.id = id;
        this.title = title;
        this.watched = watched;
    }

    private String title;

    private boolean watched;

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

    public boolean isWatched() {
        return this.watched;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }
}
