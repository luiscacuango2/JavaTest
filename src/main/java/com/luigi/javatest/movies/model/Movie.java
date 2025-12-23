package com.luigi.javatest.movies.model;

public class Movie {
    private Integer id;
    private String name;
    private int minutes;
    private Gender gender;

    public Movie(String name, int minutes, Gender gender) {
        this(null, name, minutes, gender);
    }

    public Movie(Integer id, String name, int minutes, Gender gender) {
        this.id = id;
        this.name = name;
        this.minutes = minutes;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMinutes() {
        return minutes;
    }

    public Gender getGender() {
        return gender;
    }
}
