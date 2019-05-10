/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackathon.simon.Movie_SeriesReviewApi.Utils;

import com.hackathon.simon.Movie_SeriesReviewApi.Entities.Movies;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.http.ResponseEntity;

/**
 * Movies repository interface
 *
 * @author smaingi
 */
@RepositoryRestResource(path = "api/movies", collectionResourceRel = "api/movies", itemResourceRel = "api/movie")
public interface MoviesRepository extends JpaRepository<Movies, Long> {

    List<Movies> findByWatched(Boolean watched);
}
