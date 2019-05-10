/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackathon.simon.Movie_SeriesReviewApi.Utils;

import com.hackathon.simon.Movie_SeriesReviewApi.Entities.Users;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author smaingi
 */
public interface UsersRepository extends JpaRepository<Users, Long>{
    Optional<Users> findByUsername(String username);
}
