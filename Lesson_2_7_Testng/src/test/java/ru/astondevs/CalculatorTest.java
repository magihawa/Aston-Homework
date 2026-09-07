package ru.astondevs;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorTest {

    @DataProvider(name = "addData")
    public Object[][] addData() {
        return new Object[][]{
                {0, 0, 0},
                {1, 2, 3},
                {-1, -2, -3}
        };
    }

    @Test(dataProvider = "addData")
    public void testAdd(int a, int b, int expected) {
        Assert.assertEquals(Calculator.add(a, b), expected);
    }

    @DataProvider(name = "subData")
    public Object[][] subData() {
        return new Object[][]{
                {0, 0, 0},
                {5, 3, 2},
                {-5, -3, -2}
        };
    }

    @Test(dataProvider = "subData")
    public void testSubtract(int a, int b, int expected) {
        Assert.assertEquals(Calculator.subtract(a, b), expected);
    }

    @DataProvider(name = "mulData")
    public Object[][] mulData() {
        return new Object[][]{
                {0, 5, 0},
                {2, 3, 6},
                {-2, 3, -6}
        };
    }

    @Test(dataProvider = "mulData")
    public void testMultiply(int a, int b, int expected) {
        Assert.assertEquals(Calculator.multiply(a, b), expected);
    }

    @DataProvider(name = "divData")
    public Object[][] divData() {
        return new Object[][]{
                {10, 2, 5},
                {-8, 4, -2}
        };
    }

    @Test(dataProvider = "divData")
    public void testDivide(int a, int b, int expected) {
        Assert.assertEquals(Calculator.divide(a, b), expected);
    }

    @Test(expectedExceptions = ArithmeticException.class,
            expectedExceptionsMessageRegExp = "Деление на ноль")
    public void testDivideByZero() {
        Calculator.divide(5, 0);
    }
}