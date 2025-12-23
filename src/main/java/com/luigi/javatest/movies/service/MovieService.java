package com.luigi.javatest.movies.service;

import com.luigi.javatest.movies.data.MovieRepository;
import com.luigi.javatest.movies.model.Gender;
import com.luigi.javatest.movies.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieService {
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMoviesByGender(Gender gender) {

        return movieRepository.findAll().stream()
                .filter(movie -> movie.getGender() == gender).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByLength(int length) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getMinutes() <= length).collect(Collectors.toList());
    }
}
