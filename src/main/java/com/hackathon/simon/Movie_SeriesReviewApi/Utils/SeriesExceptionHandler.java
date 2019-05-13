/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackathon.simon.Movie_SeriesReviewApi.Utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import static org.springframework.http.ResponseEntity.notFound;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Series exception handler
 * @author smaingi
 */
@RestControllerAdvice
@Slf4j
public class SeriesExceptionHandler {
     @ExceptionHandler(value = {SeriesNotFoundException.class})
    public ResponseEntity seriesNotFound(SeriesNotFoundException ex) {
        log.debug("handling SeriesNotFoundException...");
        return notFound().build();
    }
}
