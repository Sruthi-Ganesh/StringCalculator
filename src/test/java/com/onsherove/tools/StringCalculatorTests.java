package com.onsherove.tools;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        assertEquals(174, stringCalculator.add("12,2,39,56,65"));
    }

    @Test
    void additionWithNewLines() {
        assertEquals(174, stringCalculator.add("12\n2,39,56\n65"));
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
        String arrOfNumbers = StringUtils.convertIntegerArrayToString(integers);
        assertEquals(expected_sum, stringCalculator.add(arrOfNumbers));
    }

    @Test
    void additionOfString() {
        Exception exception = assertThrows(NumberFormatException.class, () -> stringCalculator.add("hello"));
        String expectedMessage = "For input string: \"hello\"";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void additionWithCustomDelimiter_1() {
        assertEquals(3, stringCalculator.add("//;\n1;2"));
    }

    @Test
    void additionWithNegativeNumbers() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> stringCalculator.add("1,2,-3,-4"));
        String expectedMessage = "Negative numbers not allowed: -3,-4";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void additionWithNegativeNumbersCustomDelimiter() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> stringCalculator.add("//;\n1;2;-3;-4"));
        String expectedMessage = "Negative numbers not allowed: -3,-4";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void additionWithNumberGreaterThan1000() {
        assertEquals(2, stringCalculator.add("2,1001"));
    }

    @Test
    void additionWithNumberGreaterThan1000CustomDelimiter() {
        assertEquals(2, stringCalculator.add("//;\n2;1001"));
    }

    @Test
    void additionWithReptitiveCustomDelimiters() {
        assertEquals(2, stringCalculator.add("//;;;\n2;;;1001"));
    }

    @Test
    void additionWithMultipleCustomDelimiters() {
        assertEquals(2, stringCalculator.add("//;;\n2;;;1001"));
    }

    @Test
    void additionWithMultipleDifferentCustomDelimiters() {
        assertEquals(6, stringCalculator.add("//[*][%]\n1*2%3"));
    }

}
