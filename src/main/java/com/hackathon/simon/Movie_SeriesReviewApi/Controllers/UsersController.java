/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackathon.simon.Movie_SeriesReviewApi.Controllers;

import com.hackathon.simon.Movie_SeriesReviewApi.Utils.UsersRepository;
import java.util.HashMap;
import java.util.Map;
import javax.naming.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import static org.springframework.http.ResponseEntity.ok;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Users rest controller
 *
 * @author smaingi
 */
@RestController
@RequestMapping("/auth")
public class UsersController {

    @Autowired
    UsersRepository users;

    /**
     * sign in endpoint. Returns token to be used by the user on successful login
     * @param data
     * @return
     */
//    @PostMapping("/signin")
//    public ResponseEntity signin(@RequestBody AuthenticationRequest data) {
//        try {
//            String username = data.getUsername();
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));
//            String token = jwtTokenProvider.createToken(username, this.users.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username " + username + "not found")).getRoles());
//            Map<Object, Object> model = new HashMap<>();
//            model.put("username", username);
//            model.put("token", token);
//            return ok(model);
//        } catch (AuthenticationException e) {
//            throw new BadCredentialsException("Invalid username/password supplied");
//        }
//    }

}
