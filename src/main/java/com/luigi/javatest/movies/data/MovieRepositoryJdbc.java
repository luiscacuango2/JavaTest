package com.luigi.javatest.movies.data;

import com.luigi.javatest.movies.model.Gender;
import com.luigi.javatest.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Collection;

public class MovieRepositoryJdbc implements MovieRepository {

    private JdbcTemplate jdbcTemplate;

    public MovieRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {
        return jdbcTemplate.queryForObject("select * from movies where id = ?", movieMapper, id);
    }

    @Override
    public Collection<Movie> findAll() {
        return jdbcTemplate.query("select * from movies", movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {
        if (movie.getId() == null) {
            // Actualizamos el INSERT para incluir el director
            jdbcTemplate.update("insert into movies (name, minutes, gender, director) values (?, ?, ?, ?)",
                    movie.getName(), movie.getMinutes(), movie.getGender().toString(), movie.getDirector());
        } else {
            // Implementamos el UPDATE (opcional pero recomendado)
            jdbcTemplate.update("update movies set name = ?, minutes = ?, gender = ?, director = ? where id = ?",
                    movie.getName(), movie.getMinutes(), movie.getGender().toString(), movie.getDirector(), movie.getId());
        }
    }

    private static RowMapper<Movie> movieMapper = (rs, rowNum) ->
            new Movie(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("minutes"),
                    Gender.valueOf(rs.getString("gender")),
                    // Obtenemos el director de la base de datos
                    rs.getString("director")
            );
}
