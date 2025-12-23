package com.luigi.javatest.movies.service;

import com.luigi.javatest.movies.data.MovieRepository;
import com.luigi.javatest.movies.model.Gender;
import com.luigi.javatest.movies.model.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

// Importamos las aserciones nativas de JUnit 5
import static org.junit.jupiter.api.Assertions.*;

public class MovieServiceShould {

    private MovieRepository movieRepository;
    private MovieService movieService;

    @BeforeEach
    void setUp() {
        // Inicializamos el mock y el servicio antes de cada test
        movieRepository = Mockito.mock(MovieRepository.class);
        movieService = new MovieService(movieRepository);
        // GIVEN
        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knight", 152, Gender.ACTION, "Christopher Nolan"),
                        new Movie(2, "Memento", 113, Gender.THRILLER, "Christopher Nolan"),
                        new Movie(3, "Super 8", 112, Gender.THRILLER, "J.J. Abrams"),
                        new Movie(4, "Superman", 103, Gender.ACTION, "Richard Donner"),
                        new Movie(5, "Home Alone", 103, Gender.COMEDY, "Chris Columbus"),
                        new Movie(6, "Home Alone", 120, Gender.COMEDY, "director1"),
                        new Movie(7, "Matrix", 136, Gender.ACTION, "director2")
                )
        );
    }

    @Test
    public void return_movies_by_gender() {
        // WHEN
        Collection<Movie> movies = movieService.findMoviesByGender(Gender.COMEDY);
        // THEN
        // Cambiamos assertThat por assertEquals de JUnit 5
        // El orden es: assertEquals(esperado, actual)
        assertEquals(Arrays.asList(5, 6), getMoviesIds(movies));
    }

    @Test
    public void return_movies_by_length() {
        // WHEN
        Collection<Movie> movies = movieService.findMoviesByLength(120);
        // THEN
        assertEquals(Arrays.asList(2, 3, 4, 5, 6), getMoviesIds(movies));
    }

    public static List<Integer> getMoviesIds(Collection<Movie> movies) {
        return movies.stream()
                .map(Movie::getId)
                .collect(Collectors.toList());
    }
    @Test
    void return_movies_by_name() {
        // Buscamos "super" (en minúsculas) para probar case-insensitivity
        Collection<Movie> movies = movieService.findMoviesByName("super");

        List<Integer> ids = movies.stream().map(Movie::getId).collect(Collectors.toList());
        assertEquals(Arrays.asList(3, 4), ids); // Super 8 y Superman
    }

    @Test
    void return_movies_by_director() {
        // Buscamos una parte del nombre "Nolan"
        Collection<Movie> movies = movieService.findMoviesByDirector("nolan");

        List<Integer> ids = movies.stream().map(Movie::getId).collect(Collectors.toList());
        assertEquals(Arrays.asList(1, 2), ids); // Dark Knight y Memento
    }
}