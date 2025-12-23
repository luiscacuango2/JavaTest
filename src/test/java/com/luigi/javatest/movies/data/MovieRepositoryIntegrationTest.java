package com.luigi.javatest.movies.data;

import com.luigi.javatest.movies.model.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.luigi.javatest.movies.service.MovieServiceShould.getMoviesIds;
import static org.junit.jupiter.api.Assertions.*;

public class MovieRepositoryIntegrationTest {
    private MovieRepositoryJdbc movieRepository;
    private DriverManagerDataSource dataSource;

    @BeforeEach
    void setUp() {
        // 1. Configurar la conexión a la base de datos H2 en memoria
        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        // Añadimos DB_CLOSE_DELAY=-1 para que la tabla no desaparezca
        dataSource.setUrl("jdbc:h2:mem:test;MODE=MYSQL;DB_CLOSE_DELAY=-1");
        dataSource.setUsername("sa");
        dataSource.setPassword("sa");

        // 2. Cargamos el script
            ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
            populator.addScript(new ClassPathResource("sql-scripts/test-data.sql"));

        // 3. Ejecutamos el populator sobre el datasource
        populator.execute(dataSource);

        // 4. Inicializar el repositorio
        movieRepository = new MovieRepositoryJdbc(new JdbcTemplate(dataSource));
    }

    @Test
    public void load_all_movies() throws SQLException {
        // Ejecutar
        Collection<Movie> movies = movieRepository.findAll();

        // Validar (Usamos una pequeña utilidad local para obtener IDs)
        List<Integer> moviesIds = movies.stream().map(Movie::getId).collect(Collectors.toList());

        assertEquals(Arrays.asList(1, 2, 3), moviesIds);
    }


}