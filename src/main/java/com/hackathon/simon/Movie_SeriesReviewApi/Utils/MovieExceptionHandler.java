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
import org.springframework.web.context.request.WebRequest;

/**
 * Exception handler advice
 * @author smaingi
 */
@RestControllerAdvice
@Slf4j
public class MovieExceptionHandler {

    @ExceptionHandler(value = {MovieNotFoundException.class})
    public ResponseEntity movieNotFound(MovieNotFoundException ex, WebRequest request) {
        log.debug("handling MovieNotFoundException...");
        return notFound().build();
    }

}
