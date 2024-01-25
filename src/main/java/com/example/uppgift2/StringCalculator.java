package com.example.uppgift2;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.length() > 1) return splitNumbers(numbers);
        if (numbers.length() == 1) return Integer.parseInt(numbers);
        return 0;
    }

    private int splitNumbers(String numbers) {
        String[] splitNumbers = numbers.split("[,\n]");
        int sum = 0;
        for (String number : splitNumbers) {
            if(!number.trim().isEmpty()) {
                sum += Integer.parseInt(number.trim());
            }
        }
        return sum;
    }
}