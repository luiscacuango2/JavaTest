package com.luigi.javatest.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanNumeralsTest {
    private RomanNumerals roman;
    /* función que convierta un número en el equivalente romano. */
    @BeforeEach
    public void setup() {
        roman = new RomanNumerals();
    }

    @Test
    @DisplayName("Debería convertir correctamente los números base (I, V, X, L, C, M)")
    public void check_base_numbers() {
        assertEquals("I", roman.arabicToRoman(1));
        assertEquals("V", roman.arabicToRoman(5));
        assertEquals("X", roman.arabicToRoman(10));
        assertEquals("L", roman.arabicToRoman(50));
        assertEquals("C", roman.arabicToRoman(100));
        assertEquals("M", roman.arabicToRoman(1000));
    }

    @Test
    public void check_subtractive_and_complex_numbers() {
        assertEquals("IV", roman.arabicToRoman(4));
        assertEquals("IX", roman.arabicToRoman(9));
        assertEquals("CXXVI", roman.arabicToRoman(126));
        assertEquals("MMDVII", roman.arabicToRoman(2507));
    }
    @Test
    public void errorConvertNumber() {
        assertEquals("Error cantidad", roman.arabicToRoman(11000));
    }

}