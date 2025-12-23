package com.luigi.javatest.movies.model;

import java.util.Objects;

public class Movie {
    private Integer id;
    private String name;
    private Integer minutes;
    private Gender gender;
    private String director; // Nuevo atributo

    public Movie(String name, int minutes, Gender gender, String director) {
        this(null, name, minutes, gender, director);
    }

    public Movie(Integer id, String name, Integer minutes, Gender gender, String director) {
        this.id = id;
        this.name = name;
        this.minutes = minutes;
        this.gender = gender;
        this.director = director;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public Gender getGender() {
        return gender;
    }

    public String getDirector() { return director; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return minutes == movie.minutes &&
                Objects.equals(id, movie.id) &&
                Objects.equals(name, movie.name) &&
                gender == movie.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, minutes, gender);
    }
}
