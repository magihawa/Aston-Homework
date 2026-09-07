package ru.astondevs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IntCompareTest {

    @ParameterizedTest(name = "compare({0}, {1}) = {2}")
    @CsvSource({"5,5,0", "5,3,1", "3,5,-1"})
    @DisplayName("Сравнение (равно, больше, меньше)")
    void testCompareInts(int a, int b, int expected) {
        assertEquals(expected, IntCompare.compareInts(a, b));
    }
}