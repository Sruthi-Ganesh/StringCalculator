package com.onsherove.tools;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isBlank()) {
            return 0;
        }
        String[] arrOfNumbers = numbers.split(",");
        int sum = 0;
        for (String numberString : arrOfNumbers) {
            int number = Integer.parseInt(numberString);
            sum += number;
        }
        return sum;
    }

    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();
        System.out.println(stringCalculator.add("1,2"));
    }
}
