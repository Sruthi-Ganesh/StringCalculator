package com.onsherove.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StringCalculatorTests {
    private final StringCalculator stringCalculator = new StringCalculator();

    @Test
    void additionOfEmptyString() {
        assertEquals(0, stringCalculator.add(""));
    }

}
