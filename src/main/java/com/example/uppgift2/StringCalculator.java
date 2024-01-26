package com.example.uppgift2;

import java.util.ArrayList;
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
        List<Integer> separatedNumbers = stringToNumbers(splitNumbers(numbers));
        findNegativeNumbers(separatedNumbers);
        return separatedNumbers.stream().reduce(0, Integer::sum);
    }
    private List<Integer> stringToNumbers(String[] split) {
        return Arrays
                .stream(split)
                .map(Integer::parseInt)
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

    private void findNegativeNumbers(List<Integer> seperatedNumbers) {
        ArrayList<Integer> negativeNumbers = new ArrayList<>();
        for (Integer integer : seperatedNumbers) {
            if (integer < 0) negativeNumbers.add(integer);
        }
        if (!negativeNumbers.isEmpty()) throw new negativesNumbersException("negatives not allowed: " + negativeNumbers);
    }

    public static class negativesNumbersException extends IllegalArgumentException {
        public negativesNumbersException(String showMessage) {
            super(showMessage);
        }
    }
}