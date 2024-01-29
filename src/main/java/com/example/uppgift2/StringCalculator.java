package com.example.uppgift2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

    private static final String defaultDelimiters = "[/,\n;]";
    private static final Pattern customDelimiter = Pattern.compile("^//(\\[.+])+\n(.*)");

    public int add(String numbers) {
        if (numbers.isEmpty()) return 0;
        return adding(numbers);
    }

    private int adding(String numbers) {
        String delimiters = defaultDelimiters;
        Matcher matcher = customDelimiter.matcher(numbers);
        if (matcher.matches()) {
            delimiters = extractDelimiters(matcher.group(1));
            numbers = matcher.group(2);
        }
        List<Integer> separatedNumbers = stringToNumbers(numbers.split(delimiters));
        findNegativeNumbers(separatedNumbers);
        return separatedNumbers.stream().filter(n -> n <= 1000).reduce(0, Integer::sum);
    }

    private String extractDelimiters(String delimiterString) {
        if (delimiterString.isEmpty()) {
            return defaultDelimiters;
        }
        StringBuilder delimiters = new StringBuilder();
        Matcher matcher = Pattern.compile("\\[(.*?)]").matcher(delimiterString);
        while (matcher.find()) {
            delimiters.append(Pattern.quote(matcher.group(1))).append("|");
        }
        if (!delimiters.isEmpty()) {
            delimiters.deleteCharAt(delimiters.length() - 1);
        } else {
            delimiters.append(Pattern.quote(delimiterString));
        }
        return delimiters.toString();
    }

    private List<Integer> stringToNumbers(String[] split) {
        return Arrays
                .stream(split)
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void findNegativeNumbers(List<Integer> seperatedNumbers) {
        ArrayList<Integer> negativeNumbers = new ArrayList<>();
        for (Integer integer : seperatedNumbers) {
            if (integer < 0) negativeNumbers.add(integer);
        }
        if (!negativeNumbers.isEmpty())
            throw new negativesNumbersException("negatives not allowed: " + negativeNumbers);
    }

    public static class negativesNumbersException extends IllegalArgumentException {
        public negativesNumbersException(String showMessage) {
            super(showMessage);
        }
    }
}

