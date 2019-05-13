/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackathon.simon.Movie_SeriesReviewApi.Controllers;

import com.hackathon.simon.Movie_SeriesReviewApi.Entities.Series;
import com.hackathon.simon.Movie_SeriesReviewApi.Utils.SeriesNotFoundException;
import com.hackathon.simon.Movie_SeriesReviewApi.Utils.SeriesRepository;
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
 * SeriesController
 *
 * @author smaingi
 */
@RestController
@RequestMapping("/api/series")
public class SeriesController {

    @Autowired
    private SeriesRepository repository;

    /**
     * get all series
     *
     * @return
     */
    @GetMapping("")
    public  ResponseEntity getAllSeries() {
        return ok(repository.findAll());
    }

    /**
     * gets watched series
     *
     * @return
     */
    @GetMapping("/watched")
    public ResponseEntity getWatchedseries() {
        return ok(repository.findByWatched(Boolean.TRUE));
    }

    /**
     * gets unwatched series
     *
     * @return
     */
    @GetMapping("/unwatched")
    public ResponseEntity getUnWatchedSeries() {
        return ok(repository.findByWatched(Boolean.FALSE));
    }

    /**
     * get series by id
     *
     * @param id
     * @return
     * @throws SeriesNotFoundException
     */
    @GetMapping("/{id}")
    public ResponseEntity<Series> getSeriesById(@PathVariable(value = "id") Long id)
            throws SeriesNotFoundException {
        Series series = repository.findById(id)
                .orElseThrow(() -> new SeriesNotFoundException(id));
        return ResponseEntity.ok().body(series);
    }

    /**
     * adds new series to the db
     *
     * @param series
     * @return
     */
    @PostMapping("")
    public ResponseEntity<Series> addSeries(@Valid @RequestBody Series series) {
        return ok(repository.save(series));
    }

    /**
     * updates exiting series details
     *
     * @param id
     * @param seriesdetails
     * @return
     * @throws SeriesNotFoundException
     */
    @PutMapping("/{id}")
    public ResponseEntity<Series> updateSeries(
            @PathVariable(value = "id") Long id, @Valid @RequestBody Series seriesdetails)
            throws SeriesNotFoundException {
        Series series
                = repository
                        .findById(id)
                        .orElseThrow(() -> new SeriesNotFoundException(id));
        series.setTitle(seriesdetails.getTitle());
        series.setDescription(seriesdetails.getDescription());
        series.setRating(seriesdetails.getRating());
        series.setRecommendation(seriesdetails.getRecommendation());
        series.setYear(seriesdetails.getYear());
        series.setWatched(seriesdetails.getWatched());

        final Series updatedSeries = repository.save(series);
        return ResponseEntity.ok(updatedSeries);
    }

    /**
     * deletes existing series details
     *
     * @param id
     * @return
     * @throws SeriesNotFoundException
     */
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteSeries(@PathVariable(value = "id") Long id) throws SeriesNotFoundException {
        Series series
                = repository
                        .findById(id)
                        .orElseThrow(() -> new SeriesNotFoundException(id));
        repository.delete(series);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
