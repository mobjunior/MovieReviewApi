/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackathon.simon.Movie_SeriesReviewApi.Utils;

import com.hackathon.simon.Movie_SeriesReviewApi.Entities.Series;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * SeriesRepository
 * @author smaingi
 */
@RepositoryRestResource(path = "series", collectionResourceRel = "series", itemResourceRel = "series")
public interface SeriesRepository extends JpaRepository<Series, Long> {

    Optional<Series> findByWatched(Boolean watched);
}
