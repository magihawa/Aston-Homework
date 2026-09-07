package ru.astondevs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @ParameterizedTest(name = "factorial({0}) = {1}")
    @CsvSource({"0,1", "5,120"})
    @DisplayName("Факториал (граница 0 и типичное положительное)")
    void testCalculateFactorial(int n, long expected) {
        assertEquals(expected, Factorial.calculateFactorial(n));
    }

    @Test
    @DisplayName("Отрицательное число -> IllegalArgumentException")
    void testNegativeFactorial() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.calculateFactorial(-1));
    }
}