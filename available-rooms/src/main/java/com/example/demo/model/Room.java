package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    boolean smoking;
    boolean disabled;
    boolean cleaned;
    int beds;

    public Room() {
    }

    public Room(boolean smoking, boolean disabled, int beds) {
        this.smoking = smoking;
        this.disabled = disabled;
        this.beds = beds;
        this.cleaned = true;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isSmoking() {
        return smoking;
    }
    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public boolean isCleaned() {
        return cleaned;
    }

    public void setCleaned(boolean cleaned) {
        this.cleaned = cleaned;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }
}
