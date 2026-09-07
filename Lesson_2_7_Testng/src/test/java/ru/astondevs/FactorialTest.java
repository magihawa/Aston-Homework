package ru.astondevs;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FactorialTest {

    @DataProvider(name = "factData")
    public Object[][] factData() {
        return new Object[][]{
                {0, 1L},
                {5, 120L}
        };
    }

    @Test(dataProvider = "factData")
    public void testCalculateFactorial(int n, long expected) {
        Assert.assertEquals(Factorial.calculateFactorial(n), expected);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Число должно быть больше или равно 0")
    public void testNegativeFactorial() {
        Factorial.calculateFactorial(-1);
    }
}