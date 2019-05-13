package com.hackathon.simon.Movie_SeriesReviewApi;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Test movie series review
 *
 * @author smaingi
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MovieSeriesReviewApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MovieSeriesReviewApiApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port + "/api";
    }

    /**
     *
     */
    @Test
    public void contextLoads() {
    }

    /**
     * testgetAllAlMovies
     */
    @Test
    public void testgetAllAlMovies() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/movies",
                HttpMethod.GET, entity, String.class);
        Assert.assertNotNull(response.getBody());
    }

    /**
     * testgetAllAlSeries
     */
    @Test
    public void testgetAllAlSeries() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/series",
                HttpMethod.GET, entity, String.class);
        Assert.assertNotNull(response.getBody());
    }

}
