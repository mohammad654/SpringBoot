package com.StartSpringBoot.Spring.Boot.models.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "tags")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "description")

    private String description;
}
