package ru.astondevs;

public class Factorial {
    public static long calculateFactorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Число должно быть больше или равно 0");
        long result = 1;
        for (int i = 2; i <= n; i++) result *= i;
        return result;
    }
}