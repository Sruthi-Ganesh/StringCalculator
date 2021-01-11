package com.onsherove.tools;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            if(number < 0) {
                negativeNumbers.add(number);
                continue;
            }
            if (number > 1000) {
                continue;
            }
            sum += number;
        }
        if(negativeNumbers.size() > 0) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + StringUtils.convertIntegerListToString(negativeNumbers));
        }
        return sum;
    }

    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();
        System.out.println(stringCalculator.add("1,2"));
    }
}
