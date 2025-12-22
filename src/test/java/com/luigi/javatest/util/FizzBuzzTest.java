package com.luigi.javatest.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class FizzBuzzTest {
    @Test
    public void case_return_fizz() {
        assertEquals("Fizz", FizzBuzz.fizzBuzz(3));
    }

    @Test
    public void case_return_buzz() {
        assertEquals("Buzz", FizzBuzz.fizzBuzz(5));
    }

    @Test
    public void case_return_fizzbuzz() {
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(15));
    }

    @Test
    public void case_return_number() {
        assertEquals("1", FizzBuzz.fizzBuzz(1));
    }

}