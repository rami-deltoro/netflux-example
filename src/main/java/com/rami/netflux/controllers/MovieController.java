package com.rami.netflux.controllers;

import com.rami.netflux.domain.Movie;
import com.rami.netflux.domain.MovieEvent;
import com.rami.netflux.service.MovieService;
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

    @GetMapping(value = "/{id}/events")
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
