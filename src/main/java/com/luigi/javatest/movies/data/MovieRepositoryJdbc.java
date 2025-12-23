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
            jdbcTemplate.update("insert into movies (name, minutes, gender) values (?, ?, ?)",
                    movie.getName(), movie.getMinutes(), movie.getGender().toString());
        }
    }

    private static RowMapper<Movie> movieMapper = (rs, rowNum) ->
            new Movie(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("minutes"),
                    // Convertir String a Enum
                    Gender.valueOf(rs.getString("gender"))
            );
}
