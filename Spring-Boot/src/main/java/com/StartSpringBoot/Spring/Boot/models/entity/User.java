package com.StartSpringBoot.Spring.Boot.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
    public Long getId() {
        return id;
    }

    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Id
    private Long id;
    private String name;
    private String email;

    // Constructors, getters, and setters
}
