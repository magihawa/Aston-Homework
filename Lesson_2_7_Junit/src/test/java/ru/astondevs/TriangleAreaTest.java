package ru.astondevs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class TriangleAreaTest {

    private static final double DELTA = 1e-9;

    @ParameterizedTest(name = "Площадь ({0},{1},{2}) ≈ {3}")
    @CsvSource({"1,1,1,0.4330127019", "3,4,5,6.0"})
    @DisplayName("Валидные треугольники (равносторонний, разносторонний)")
    void testValidTriangle(int a, int b, int c, double expected) {
        assertEquals(expected, TriangleArea.getTriangleArea(a, b, c), DELTA);
    }

    @Test
    @DisplayName("Невалидный треугольник -> NaN")
    void testInvalidTriangle() {
        assertTrue(Double.isNaN(TriangleArea.getTriangleArea(1, 1, 10)));
    }
}