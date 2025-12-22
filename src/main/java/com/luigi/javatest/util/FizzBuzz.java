package com.luigi.javatest.util;

public class FizzBuzz {
    public static String fizzBuzz(int number) {
        String result = "";

        if(number % 3 == 0 && number % 5 == 0) result += "FizzBuzz";
        else if(number % 3 == 0) result += "Fizz";
        else if(number % 5 == 0) result += "Buzz";
        else result += number;

        return result;
    }
}
