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

    @Test
    @DisplayName("Given 1,2 return 3")
    void given12ShouldReturn3() {
        assertThat(stringCalculator.add("1,2")).isEqualTo(3);
    }

    @Test
    @DisplayName("Given 1,2,3,4,5,6 return 21")
    void given123Return6() {
        assertThat(stringCalculator.add("1,2,3,4,5,6")).isEqualTo(21);

    }

    @Test
    @DisplayName("Given 4,4 returns 8")
    void given44Returns8() {
        assertThat(stringCalculator.add("4,4")).isEqualTo(8);
    }

    @Test
    @DisplayName("Given 50,50 returns 100")
    void given5050Returns100() {
        assertThat(stringCalculator.add("50,50")).isEqualTo(100);
    }
}