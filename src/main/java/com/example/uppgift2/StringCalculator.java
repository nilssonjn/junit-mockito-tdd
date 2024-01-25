package com.example.uppgift2;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.length() > 1) return splitNumbers(numbers);
        if (numbers.length() == 1) return Integer.parseInt(numbers);
        return 0;
    }

    private int splitNumbers(String numbers) {
        String[] splitNumbers = numbers.split(",");
        int sum = 0;
        for (String number : splitNumbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}