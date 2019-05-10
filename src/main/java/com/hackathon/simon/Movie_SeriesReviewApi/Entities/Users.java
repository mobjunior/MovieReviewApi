/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackathon.simon.Movie_SeriesReviewApi.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 * Entity for users who review the movies and series.
 * @author smaingi
 */
@Data // helps creates setters and getters automatically
@Entity
public class Users {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String username;
    private String password;

    /**
     * Default constructor for Users entity class
     */
    public Users() {
    }

    /**
     * Users constructor
     * @param userId
     * @param username
     * @param password
     */
    public Users(Long userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }
    
}
