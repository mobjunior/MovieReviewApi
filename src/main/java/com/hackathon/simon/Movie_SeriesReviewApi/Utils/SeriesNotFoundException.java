/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackathon.simon.Movie_SeriesReviewApi.Utils;

/**
 *
 * @author smaingi
 */
public class SeriesNotFoundException extends RuntimeException {

    /**
     * SeriesNotFoundException constructor
     *
     * @param id
     */
    public SeriesNotFoundException(Long id) {
        super("Could not find series with id::" + id);
    }
}
