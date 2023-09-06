package com.Full.Full.Stack.App.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "movies")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "movie")
    private String movie;
    @Column(name = "description")
    private String description;
    @Column(name = "audio")
    private String audio;
    @Column(name = "url")
    private String url;
    @Column(name = "subtitle")
    private String subtitle;
    @Column(name = "ownRating")
    private String ownRating;
    @Column(name = "rating")
    private String rating;
    @Column(name = "genre")
    private String genre;
}
