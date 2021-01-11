package com.onsherove.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isBlank()) {
            return 0;
        }
        DelimiterUtils delimiterUtils = new DelimiterUtils(numbers);
        String delimiter = delimiterUtils.getDelimiter();
        if (delimiter != null) {
            numbers = delimiterUtils.getDelimiterRemovedFromString();
        }
        List<Integer> negativeNumbers = new ArrayList<>();
        String[] arrOfNumbers = numbers.split(Objects.requireNonNullElse(delimiter, "[,\n]+"));
        int sum = 0;
        for (String numberString : arrOfNumbers) {
            int number = Integer.parseInt(numberString.trim());
            if (number < 0) {
                negativeNumbers.add(number);
                continue;
            }
            if (number > 1000) {
                continue;
            }
            sum += number;
        }
        if (negativeNumbers.size() > 0) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + StringUtils.convertIntegerListToString(negativeNumbers));
        }
        return sum;
    }
}
