package com.luigi.javatest.util;

public class StringUtil {

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() <= 0;
    }

    public static String repeat(String str, int times) {

        if (times < 0) {
            throw new IllegalArgumentException("tiempos negativos no permitidos");
        }

        String result = "";

        for (int i = 0; i < times; i++) {
            result += str;
        }

        return result;
    }
}
