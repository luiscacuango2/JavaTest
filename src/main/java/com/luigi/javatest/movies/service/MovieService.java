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

    public Collection<Movie> findMoviesByName(String name) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByDirector(String director) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getDirector().toLowerCase().contains(director.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByTemplate(Movie template) {
        // Regla: Si hay ID, ignoramos lo demás
        if (template.getId() != null) {
            return movieRepository.findAll().stream()
                    .filter(m -> m.getId().equals(template.getId()))
                    .collect(Collectors.toList());
        }

        // Regla: Minutos negativos lanzan excepción
        if (template.getMinutes() != null && template.getMinutes() < 0) {
            throw new IllegalArgumentException("Los minutos no pueden ser negativos");
        }

        return movieRepository.findAll().stream()
                .filter(m -> template.getName() == null || m.getName().toLowerCase().contains(template.getName().toLowerCase().trim()))
                .filter(m -> template.getMinutes() == null || m.getMinutes() <= template.getMinutes())
                .filter(m -> template.getGender() == null || m.getGender().equals(template.getGender()))
                .filter(m -> template.getDirector() == null || m.getDirector().toLowerCase().contains(template.getDirector().toLowerCase().trim()))
                .collect(Collectors.toList());
    }
}
