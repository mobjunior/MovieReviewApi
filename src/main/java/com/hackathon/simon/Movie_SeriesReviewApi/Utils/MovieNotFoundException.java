/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackathon.simon.Movie_SeriesReviewApi.Utils;

/**
 * MovieNotFoundException handler
 *
 * @author smaingi
 */
public class MovieNotFoundException extends RuntimeException {

    /**
     * MovieNotFoundException constructor
     * @param id
     */
    public MovieNotFoundException(Long id) {
        super("Could not find movie with id::" + id);
    }

}
