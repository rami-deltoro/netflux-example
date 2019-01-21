package com.rami.netflux.repositories;

import com.rami.netflux.domain.Movie;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

public interface MovieRepository extends ReactiveCassandraRepository<Movie,String> {
}
