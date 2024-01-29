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

    @Test
    @DisplayName("Given new lines between numbers should still return 6")
    void givenNewLinesBetweenNumbersShouldStillReturn6() {
        assertThat(stringCalculator.add("1\n2,3")).isEqualTo(6);
    }

    @Test
    @DisplayName("Given lines with custom delimiters between numbers should still return 3")
    void givenLinesWithCustomDelimitersBetweenNumbersShouldStillReturn3() {
        assertThat(stringCalculator.add("//;\n1;2")).isEqualTo(3);
    }

    @Test
    @DisplayName("Given a negative number return negative exception with message")
    void givenANegativeNumberReturnNegativeExceptionWithMessage() {
        StringCalculator.negativesNumbersException exception = assertThrows(
                StringCalculator.negativesNumbersException.class, () ->
                        stringCalculator.add("-4")
        );

        String expectedMessage = "negatives not allowed: [-4]";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("Given multiple negative numbers return negative exception with message")
    void givenMultipleNegativeNumbersReturnNegativeExceptionWithMessage() {
        StringCalculator.negativesNumbersException exception = assertThrows(
                StringCalculator.negativesNumbersException.class, () ->
                        stringCalculator.add("-4,-5")
        );

        String expectedMessage = "negatives not allowed: [-4, -5]";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("Given number bigger than 1000 should be ignored")
    void givenNumberBiggerThan1000ShouldBeIgnored() {
        assertThat(stringCalculator.add("1001,4")).isEqualTo(4);
    }

    @Test
    @DisplayName("Given delimiter with any length should still return right amount")
    void givenDelimiterWithAnyLengthShouldStillReturnRightAmount() {
        assertThat(stringCalculator.add("//[***]\n1***2***3")).isEqualTo(6);
    }

    @Test
    @DisplayName("Given multiple delimiters should still return right amount")
    void givenMultipleDelimitersShouldStillReturnRightAmount() {
        assertThat(stringCalculator.add("//[*][%]\n1*2%3")).isEqualTo(6);
    }

    @Test
    @DisplayName("Given multiple delimiters with length longer than one char")
    void givenMultipleDelimitersWithLengthLongerThanOneChar() {
        assertThat(stringCalculator.add("//[***][%%]\n1***4%%5")).isEqualTo(10);
    }

    @Test
    @DisplayName("Given empty delimiter string should return default delimiters")
    void givenEmptyDelimiterStringShouldReturnDefaultDelimiters() {
        assertThat(stringCalculator.extractDelimiters("")).isEqualTo("[/,\n;]");
    }

    @Test
    @DisplayName("Given empty delimiter string without custom delimiters should return quoted delimiters")
    void givenEmptyDelimiterStringWithoutCustomDelimitersShouldReturnQuotedDelimiters() {
        assertThat(stringCalculator.extractDelimiters(";")).isEqualTo("\\Q;\\E");
    }
}