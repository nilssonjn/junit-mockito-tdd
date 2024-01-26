package com.example.uppgift2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    String delimiters;
    int convertStringToNumber;

    public int add(String numbers) {
        if (numbers.isEmpty()) return 0;
        return adding(numbers);
    }

    private int adding(String numbers) {
        List<Integer> splittedNumbers = stringToNumbers(splitNumbers(numbers));
        return splittedNumbers.stream().reduce(0, Integer::sum);
    }
    private List<Integer> stringToNumbers(String[] split) {
        return Arrays.stream(split)
                .map(this::handleNegativeException)
                .collect(Collectors.toList());
    }

    private String[] splitNumbers(String numbers) {
        if (numbers.startsWith("//")) {
            delimiters = "[\n;]";
            return numbers.substring(3).replaceAll("\\s+","").split(delimiters);
        } else {
            delimiters = "[,\n]";
        } return numbers.split(delimiters);
    }

    private int handleNegativeException(String numbers) {
        convertStringToNumber = Integer.parseInt(numbers);
        if (convertStringToNumber < 0) throw new negativesNumbersException("negatives not allowed: " + convertStringToNumber);
        return convertStringToNumber;
    }

    public static class negativesNumbersException extends IllegalArgumentException {
        public negativesNumbersException(String showMessage) {
            super(showMessage);
        }
    }
}