package com.rami.netflux.controllers;

import com.rami.netflux.domain.Movie;
import com.rami.netflux.domain.MovieEvent;
import com.rami.netflux.service.MovieService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;


    public MovieController(final MovieService movieService) {
        this.movieService=movieService;
    }

    // curl http://127.0.0.1:8080/movies/01a8c8cb-f2e6-46b2-8bb4-cd1cb869adb6/events
    // This detects subscribers
    @GetMapping(value = "/{id}/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<MovieEvent> streamMovieEvents(@PathVariable final String id){
        return movieService.events(id);
    }

    @GetMapping(value = "/{id}")
    public Mono<Movie> getMovieById(@PathVariable final String id) {
        return movieService.getMovieById(id);
    }

    @GetMapping
    public Flux<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }
}
