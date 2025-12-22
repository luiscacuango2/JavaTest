package com.luigi.javatest.util;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RomanNumeralsTest {
    private RomanNumerals roman;
    /* función que convierta un número en el equivalente romano. */
    @Before
    public void setup(){
        roman = new RomanNumerals();
    }

    @Test
    public void check_base_numbers(){
        assertThat(roman.arabicToRoman(1), is("I"));
        assertThat(roman.arabicToRoman(2), is("II"));
        assertThat(roman.arabicToRoman(3), is("III"));
        assertThat(roman.arabicToRoman(4), is("IV"));
        assertThat(roman.arabicToRoman(5), is("V"));
        assertThat(roman.arabicToRoman(6), is("VI"));
        assertThat(roman.arabicToRoman(7), is("VII"));
        assertThat(roman.arabicToRoman(8), is("VIII"));
        assertThat(roman.arabicToRoman(9), is("IX"));
        assertThat(roman.arabicToRoman(10), is("X"));
        assertThat(roman.arabicToRoman(50), is("L"));
        assertThat(roman.arabicToRoman(100), is("C"));
        assertThat(roman.arabicToRoman(1000), is("M"));
    }

    @Test
    public void check_random_numbers(){
        assertThat(roman.arabicToRoman(11), is("XI"));
        assertThat(roman.arabicToRoman(15), is("XV"));
        assertThat(roman.arabicToRoman(16), is("XVI"));
        assertThat(roman.arabicToRoman(51), is("LI"));
        assertThat(roman.arabicToRoman(55), is("LV"));
        assertThat(roman.arabicToRoman(56), is("LVI"));
        assertThat(roman.arabicToRoman(60), is("LX"));
        assertThat(roman.arabicToRoman(70), is("LXX"));
        assertThat(roman.arabicToRoman(80), is("LXXX"));
        assertThat(roman.arabicToRoman(81), is("LXXXI"));
        assertThat(roman.arabicToRoman(85), is("LXXXV"));
        assertThat(roman.arabicToRoman(86), is("LXXXVI"));
        assertThat(roman.arabicToRoman(126), is("CXXVI"));
        assertThat(roman.arabicToRoman(2507), is("MMDVII"));
    }

    @Test
    public void errorConvertNumber(){
        assertThat(roman.arabicToRoman(11000), is("Error cantidad"));
    }

}