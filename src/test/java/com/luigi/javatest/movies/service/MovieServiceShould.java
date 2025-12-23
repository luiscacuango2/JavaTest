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
    }

    @Test
    public void return_movies_by_gender() {
        // GIVEN
        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knight", 152, Gender.ACTION),
                        new Movie(2, "Memento", 113, Gender.THRILLER),
                        new Movie(3, "Matrix", 136, Gender.COMEDY),
                        new Movie(4, "Super 8", 112, Gender.THRILLER),
                        new Movie(5, "Scream", 111, Gender.HORROR),
                        new Movie(6, "Home Alone", 103, Gender.COMEDY),
                        new Movie(7, "Matrix", 136, Gender.ACTION)
                )
        );

        // WHEN
        Collection<Movie> movies = movieService.findMoviesByGender(Gender.COMEDY);

        // THEN
        List<Integer> moviesIds = movies.stream()
                .map(Movie::getId)
                .collect(Collectors.toList());

        // Cambiamos assertThat por assertEquals de JUnit 5
        // El orden es: assertEquals(esperado, actual)
        assertEquals(Arrays.asList(3, 6), moviesIds);
    }
}