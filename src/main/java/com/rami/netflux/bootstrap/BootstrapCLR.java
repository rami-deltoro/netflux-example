package com.rami.netflux.bootstrap;

import com.rami.netflux.domain.Movie;
import com.rami.netflux.repositories.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Component
public class BootstrapCLR implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(BootstrapCLR.class);

    @Autowired
    private MovieRepository movieRepository;


    @Override
    public void run(String... args) throws Exception {

        movieRepository.deleteAll()
                .thenMany(
                        Flux.just("Terminator 2","Jumanji", "Emoji Movie","Casper")
                                .map(title -> new Movie(title, UUID.randomUUID().toString()))
                                .flatMap(movieRepository::save))
                .subscribe(null,null, () -> {
                    movieRepository.findAll().subscribe(System.out::println);
                });
    }
}
