package com.example.uppgift2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    String delimiters;

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
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private String[] splitNumbers(String numbers) {
        if (numbers.startsWith("//")) {
            delimiters = "[\n;]";
            return numbers.substring(4).replaceAll("\\s+","").split(delimiters);
        } else {
            delimiters = "[,\n]";
        } return numbers.split(delimiters);
    }
}