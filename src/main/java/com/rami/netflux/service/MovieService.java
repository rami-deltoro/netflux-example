package com.rami.netflux.service;

import com.rami.netflux.domain.Movie;
import com.rami.netflux.domain.MovieEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieService {

    Flux<MovieEvent> events(final String movieId);


    Mono<Movie> getMovieById(final String id);

    Flux<Movie> getAllMovies();
}
