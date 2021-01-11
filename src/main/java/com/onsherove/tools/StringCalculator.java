package com.onsherove.tools;

import java.util.Objects;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isBlank()) {
            return 0;
        }
        String delimiter = this.getDelimiter(numbers);
        if (delimiter != null) {
            numbers = this.getDelimiterRemovedFromString(numbers);
        }
        String[] arrOfNumbers = numbers.split(Objects.requireNonNullElse(delimiter, "[,\n]+"));
        int sum = 0;
        for (String numberString : arrOfNumbers) {
            int number = Integer.parseInt(numberString.trim());
            sum += number;
        }
        return sum;
    }

    private boolean supportsDifferentDelimiter(String numbers) {
        return numbers.startsWith("//");
    }

    private String getDelimiter(String numbers) {
        if (this.supportsDifferentDelimiter(numbers)) {
            String delimiter = numbers.split("\n")[0];
            return String.valueOf(delimiter.charAt(2));
        }
        return null;
    }

    private String getDelimiterRemovedFromString(String numbersWithDelimiter) {
        if (this.supportsDifferentDelimiter(numbersWithDelimiter)) {
            String[] numbers = numbersWithDelimiter.split("\n");
            return StringUtils.convertStringArrayToString(StringUtils.removeStartingIndex(numbers, 0));
        }
        return numbersWithDelimiter;
    }

    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();
        System.out.println(stringCalculator.add("1,2"));
    }
}
