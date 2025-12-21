package com.luigi.javatest.util;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.*;

public class StringUtilTest {

    @Test
    @DisplayName("Cuando la cadena tiene caracteres")
    public void word_is_not_empty() {
        assertFalse(StringUtil.isEmpty("palabra"));
    }

    @Test
    @DisplayName("Cuando la cadena está vacía")
    public void quotation_marks_is_Empty() {
        assertTrue(StringUtil.isEmpty(""));
    }

    @Test
    @DisplayName("Cuando la cadena solo tiene espacios")
    public void space_is_empty() {
        assertTrue(StringUtil.isEmpty(" "));
    }

    @Test
    @DisplayName("Cuando la cadena es nula")
    public void null_is_empty() {
        assertTrue(StringUtil.isEmpty(null));
    }

    @Test
    public void repeat_string_once() {
        assertEquals("hola", StringUtil.repeat("hola", 1));
    }

    @Test
    public void repeat_string_multiple_times() {
        assertEquals("holaholahola", StringUtil.repeat("hola", 3));
    }

    @Test
    public void repeat_string_zero_times() {
        assertEquals("", StringUtil.repeat("hola", 0));
    }

    @Test(expected=IllegalArgumentException.class)
    public void repeat_string_negative_times() {
        StringUtil.repeat("hola", -1);
    }

}