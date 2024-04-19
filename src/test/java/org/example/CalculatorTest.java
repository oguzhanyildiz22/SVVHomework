package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/*
Student Number : B211202029
Name Surname   : Oğuzhan YILDIZ
Course Name    : Software Verification and Validation
Homework       : Creating a data-driven test (parameterized test) using JUnit5.
Github repo    : https://github.com/oguzhanyildiz22/SVVHomework
*/

class CalculatorTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testDivision1() {
        assertEquals(5, Calculator.divide(10, 2));
    }

    @Test
    void testDivision2() {
        assertEquals(2.5, Calculator.divide(10, 4));
    }

    @Test
    void testDivision3() {
        assertEquals(5, Calculator.divide(12.5f, 2.5f));
    }

    @Test
    void testDivision4() {
        assertEquals(4, Calculator.divide(10, 2.5f));
    }

    @Test
    void testDivision5() {
        assertEquals(2.5f, Calculator.divide(12.5f, 5));
    }

    @Test
    void testDivision6() {
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> Calculator.divide(12.5f, 0),
                "IllegalArgumentException expected."
        );

        // Optional. To check whether the error messages match.
        assertEquals("Illegal Argument Exception.", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "10, 2, 5",         // testDivision1
            "10, 4, 2.5",       // testDivision2
            "12.5f, 2.5f, 5",   // testDivision3
            "10, 2.5f, 4",      // testDivision4
            "12.5f, 5, 2.5f"    // testDivision5
    })
    void testDivision(float dividend, float divisor, float expectedResult) {
        assertEquals(expectedResult, Calculator.divide(dividend, divisor));
    }
}