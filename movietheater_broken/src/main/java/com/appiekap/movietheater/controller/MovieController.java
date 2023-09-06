package com.appiekap.movietheater.controller;

import com.appiekap.movietheater.exception.NotFoundException;
import com.appiekap.movietheater.model.Movie;
import com.appiekap.movietheater.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * MovieController
 * @author Sjakie Kannietcoderen
 */
@RestController
@RequestMapping("api/movie/")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    /**
     * createMovie movie
     * @param movie to be created.
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
       // this.movieRepository.save(movie);
        return ResponseEntity.ok().body(movieRepository.save(movie));
    }


    /**
     * getAllMovies movies
     * @return Iterable of movies.
     */
    @RequestMapping(value = "all", method = RequestMethod.GET)
    public Iterable<Movie> getAllMovies() {
        // TODO For testing purposes, please remove.
        List<Movie> testmovies = new ArrayList<>();
        testmovies.add(new Movie(1, "Test", true));
        return movieRepository.findAll();

        // TODO Uncomment for real db data.
        //return this.movieRepository.findAll();
    }

    /**
     * getMovieByTitle movies
     * @param title String of the movie title.
     * @return Iterable of movies.
     */
    @RequestMapping(value = "title/{title}", method = RequestMethod.GET)
    public Iterable<Movie> getMovieByTitle(@PathVariable String title) {
        List<Movie> movies = this.movieRepository.findByTitle(title);
        if(movies == null  || movies.size() == 0)
           throw new NotFoundException();
        return movies;
    }

    /**
     * toggleMovieWatched movie
     * @param id Id of the movie.
     */
    @RequestMapping(value = "watched/{id}", method = RequestMethod.PUT)
    public void toggleMovieWatched(@PathVariable long id) {
        Optional<Movie> movie = this.movieRepository.findById(id);

        if (movie.isEmpty())
            throw new NotFoundException();

        // Flip da shit.
        Movie watchedMovie = movie.get();
        watchedMovie.setWatched(!watchedMovie.isWatched());

        this.movieRepository.save(watchedMovie);
    }

    /**
     * deleteMovie
     * @param id Id of the movie.
     */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public void deleteMovie(@PathVariable long id) {
        Optional<Movie> movie = this.movieRepository.findById(id);

        if (movie.isEmpty())
            throw new NotFoundException();

        this.movieRepository.delete(movie.get());
    }
}