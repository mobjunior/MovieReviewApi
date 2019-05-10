/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackathon.simon.Movie_SeriesReviewApi.Utils;

import com.hackathon.simon.Movie_SeriesReviewApi.Entities.Movies;
import com.hackathon.simon.Movie_SeriesReviewApi.Entities.Series;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * pre-load the db with sample movies and series
 *
 * @author smaingi
 */
@Configuration
@Slf4j
public class DBPreloading {

    @Bean
    CommandLineRunner moviesTable(MoviesRepository repository) {
        return args -> {
            //Movies(Long movieId, String title, String description, int year, String recommendation, int rating, Boolean watched) {
            log.info("Preloading " + repository.save(new Movies(Long.valueOf(1), "Avengers1", "fiction", 2016, "great", 5, true)));
            log.info("Preloading " + repository.save(new Movies(Long.valueOf(2), "Avenger2", "fiction", 2017, "great", 4, false)));
            log.info("Preloading " + repository.save(new Movies(Long.valueOf(3), "Avenger3", "fiction", 2018, "great", 3, false)));
            log.info("Preloading " + repository.save(new Movies(Long.valueOf(4), "Avenger4", "fiction", 2019, "great", 5, true)));
        };
    }

    @Bean
    CommandLineRunner seriesTable(SeriesRepository repository) {
        return args -> {
            //Movies(Long movieId, String title, String description, int year, String recommendation, int rating, Boolean watched) {
            log.info("Preloading " + repository.save(new Series(Long.valueOf(1), "Avengers1", "fiction", 2016, "great", 5, true)));
            log.info("Preloading " + repository.save(new Series(Long.valueOf(2), "Avenger2", "fiction", 2017, "great", 4, true)));
            log.info("Preloading " + repository.save(new Series(Long.valueOf(3), "Avenger3", "fiction", 2018, "great", 3, true)));
            log.info("Preloading " + repository.save(new Series(Long.valueOf(4), "Avenger4", "fiction", 2019, "great", 5, true)));
        };
    }
}
