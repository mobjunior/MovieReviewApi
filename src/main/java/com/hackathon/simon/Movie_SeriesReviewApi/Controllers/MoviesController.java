/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackathon.simon.Movie_SeriesReviewApi.Controllers;

import com.hackathon.simon.Movie_SeriesReviewApi.Entities.Movies;
import com.hackathon.simon.Movie_SeriesReviewApi.Utils.MovieNotFoundException;
import com.hackathon.simon.Movie_SeriesReviewApi.Utils.MoviesRepository;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import static org.springframework.http.ResponseEntity.ok;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Movies controller
 *
 * @author smaingi
 */
@RestController
@RequestMapping("/api/movies")
public class MoviesController {

    @Autowired
    private MoviesRepository repository;

    /**
     * get all movies
     *
     * @return
     */
    @GetMapping("")
    public ResponseEntity getAllAlMovies() {
        return ok(repository.findAll());
    }

    /**
     * gets watched movies
     *
     * @return
     */
    @GetMapping("/watched")
    public ResponseEntity getWatchedMovies() {
        return ok(repository.findByWatched(Boolean.TRUE));
    }

    /**
     * gets unwatched movies
     *
     * @return
     */
    @GetMapping("/unwatched")
    public ResponseEntity getUnWatchedMovies() {
        return ok(repository.findByWatched(Boolean.FALSE));
    }

    /**
     * get movie by id
     *
     * @param id
     * @return
     * @throws MovieNotFoundException
     */
    @GetMapping("/{id}")
    public ResponseEntity<Movies> getMovieById(@PathVariable(value = "id") Long id)
            throws MovieNotFoundException {
        Movies movie = repository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
        return ResponseEntity.ok().body(movie);
    }

    /**
     * adds new movie to the db
     *
     * @param movie
     * @return
     */
    @PostMapping("")
    public Movies addMovie(@Valid @RequestBody Movies movie) {
        return repository.save(movie);
    }

    /**
     * updates exiting movie details
     *
     * @param id
     * @param moviedetails
     * @return
     * @throws MovieNotFoundException
     */
    @PutMapping("/{id}")
    public ResponseEntity<Movies> updateMovie(
            @PathVariable(value = "id") Long id, @Valid @RequestBody Movies moviedetails)
            throws MovieNotFoundException {
        Movies movie
                = repository
                        .findById(id)
                        .orElseThrow(() -> new MovieNotFoundException(id));
        movie.setTitle(moviedetails.getTitle());
        movie.setDescription(moviedetails.getDescription());
        movie.setRating(moviedetails.getRating());
        movie.setRecommendation(moviedetails.getRecommendation());
        movie.setYear(moviedetails.getYear());
        movie.setWatched(moviedetails.getWatched());

        final Movies updatedMovie = repository.save(movie);
        return ResponseEntity.ok(updatedMovie);
    }

    /**
     * deletes existing movie details
     *
     * @param id
     * @return
     * @throws MovieNotFoundException
     */
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteMovie(@PathVariable(value = "id") Long id) throws MovieNotFoundException {
        Movies movie
                = repository
                        .findById(id)
                        .orElseThrow(() -> new MovieNotFoundException(id));
        repository.delete(movie);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
