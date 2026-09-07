package ru.astondevs;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TriangleAreaTest {

    private static final double DELTA = 1e-9;

    @DataProvider(name = "validData")
    public Object[][] validData() {
        return new Object[][]{
                {1, 1, 1, 0.4330127019},
                {3, 4, 5, 6.0}
        };
    }

    @Test(dataProvider = "validData")
    public void testValidTriangle(int a, int b, int c, double expected) {
        Assert.assertEquals(TriangleArea.getTriangleArea(a, b, c), expected, DELTA);
    }

    @Test
    public void testInvalidTriangle() {
        double area = TriangleArea.getTriangleArea(1, 1, 10);
        Assert.assertTrue(Double.isNaN(area), "Ожидается NaN");
    }
}