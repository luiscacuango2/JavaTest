package com.luigi.javatest.util;

public class DateUtil {

    public static boolean isLeapYear(int year) {
        // Un año es bisiesto si:
        // (Es divisible por 4 Y no es divisible por 100) O (Es divisible por 400)
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
