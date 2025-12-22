package com.luigi.javatest.util;

public class StringUtil {

    public static boolean isEmpty(String str) {
        // Un String es vacío si es nulo o si al quitar espacios su longitud es 0
        return str == null || str.trim().length() == 0;
    }

    public static String repeat(String str, int times) {
        if (times < 0) {
            throw new IllegalArgumentException("El número de repeticiones no puede ser negativo");
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < times; i++) {
            result.append(str);
        }
        return result.toString();
    }
}