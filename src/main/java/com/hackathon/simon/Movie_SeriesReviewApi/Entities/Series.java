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
 * Series Entity class
 * @author smaingi
 */
@Data
@Entity
public class Series implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long seriesId;
    private String title;
    private String description;
    private int year;
    private String recommendation;
    private  int rating;
    private Boolean watched;

    /**
     * Series default constructor
     */
    public Series() {
    }

    /**
     * Series constructor
     * @param seriesId
     * @param title
     * @param description
     * @param year
     * @param recommendation
     * @param rating
     * @param watched
     */
    public Series(Long seriesId, String title, String description, int year, String recommendation, int rating, Boolean watched) {
        this.seriesId = seriesId;
        this.title = title;
        this.description = description;
        this.year = year;
        this.recommendation = recommendation;
        this.rating = rating;
        this.watched = watched;
    }
    
    
}
