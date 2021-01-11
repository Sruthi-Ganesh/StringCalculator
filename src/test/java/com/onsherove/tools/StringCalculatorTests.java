package com.onsherove.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

public class StringCalculatorTests {
    private final StringCalculator stringCalculator = new StringCalculator();

    @Test
    void additionOfEmptyString() {
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    void additionOfOneNumber() {
        assertEquals(12, stringCalculator.add("12"));
    }

    @Test
    void additionOfTwoNumbers() {
        assertEquals(14, stringCalculator.add("12,2"));
    }

    @Test
    void additionOfMultipleNumbers() {
        assertEquals(109, stringCalculator.add("12,2,39,56"));
    }

    @Test
    void additionOfRandomNumbers() {
        Random rand = new Random();
        int expected_sum = 0;
        int random_size = rand.nextInt(1000);
        int[] integers = new int[random_size];
        for (int i = 0; i < random_size; i++) {
            int rand_int = rand.nextInt(1000);
            integers[i] = rand_int;
            expected_sum += rand_int;
        }
        String arrOfNumbers = Arrays.toString(integers);
        arrOfNumbers = arrOfNumbers.replace("[", "").replace("]", "");
        assertEquals(expected_sum, stringCalculator.add(arrOfNumbers));
    }

    @Test
    void additionOfString() {
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            stringCalculator.add("hello");
        });
        String expectedMessage = "For input string: \"hello\"";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

}
