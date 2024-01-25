package com.example.uppgift2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    StringCalculator stringCalculator;
    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    @DisplayName("Given empty string, return zero")
    void givenEmptyStringReturnZero() {

        assertThat(stringCalculator.add("")).isEqualTo(0);
    }

    @Test
    @DisplayName("Given 1 return 1")
    void given1Return1() {

        assertThat(stringCalculator.add("1")).isEqualTo(1);
    }
}