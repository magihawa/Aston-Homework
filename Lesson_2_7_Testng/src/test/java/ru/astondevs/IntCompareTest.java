package ru.astondevs;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class IntCompareTest {

    @DataProvider(name = "cmpData")
    public Object[][] cmpData() {
        return new Object[][]{
                {5, 5, 0},
                {5, 3, 1},
                {3, 5, -1}
        };
    }

    @Test(dataProvider = "cmpData")
    public void testCompareInts(int a, int b, int expected) {
        Assert.assertEquals(IntCompare.compareInts(a, b), expected);
    }
}