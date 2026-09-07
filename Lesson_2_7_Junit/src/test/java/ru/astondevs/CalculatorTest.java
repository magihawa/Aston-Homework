package ru.astondevs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({"0,0,0", "1,2,3", "-1,-2,-3"})
    @DisplayName("Сложение (нули, положительные, отрицательные)")
    void testAdd(int a, int b, int expected) {
        assertEquals(expected, Calculator.add(a, b));
    }

    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource({"0,0,0", "5,3,2", "-5,-3,-2"})
    @DisplayName("Вычитание (нули, положительные, отрицательные)")
    void testSubtract(int a, int b, int expected) {
        assertEquals(expected, Calculator.subtract(a, b));
    }

    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource({"0,5,0", "2,3,6", "-2,3,-6"})
    @DisplayName("Умножение (ноль, положительные, смешанные знаки)")
    void testMultiply(int a, int b, int expected) {
        assertEquals(expected, Calculator.multiply(a, b));
    }

    @ParameterizedTest(name = "{0} / {1} = {2}")
    @CsvSource({"10,2,5", "-8,4,-2"})
    @DisplayName("Деление (положительные и смешанные знаки)")
    void testDivide(int a, int b, int expected) {
        assertEquals(expected, Calculator.divide(a, b));
    }

    @Test
    @DisplayName("Деление на ноль -> ArithmeticException")
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> Calculator.divide(5, 0));
    }
}