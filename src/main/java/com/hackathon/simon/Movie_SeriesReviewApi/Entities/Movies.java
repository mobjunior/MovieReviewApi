/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackathon.simon.Movie_SeriesReviewApi.Entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 * Movies entity class
 * @author smaingi
 */
@Data
@Entity
public class Movies implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long movieId;
    private String title;
    private String description;
    private int year;
    private String recommendation;
    private int  rating;
    private Boolean watched;

    /**
     * Movies default constructor
     */
    public Movies() {
    }

    /**
     * Movies constructor
     * @param movieId
     * @param title
     * @param description
     * @param year
     * @param recommendation
     * @param rating
     * @param watched
     */
    public Movies(Long movieId, String title, String description, int year, String recommendation, int rating, Boolean watched) {
        this.movieId = movieId;
        this.title = title;
        this.description = description;
        this.year = year;
        this.recommendation = recommendation;
        this.rating = rating;
        this.watched = watched;
    }
    
    
    
}
