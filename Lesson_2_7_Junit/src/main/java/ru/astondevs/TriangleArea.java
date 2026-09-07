package ru.astondevs;

public class TriangleArea {
    public static double getTriangleArea(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0 || a + b <= c || a + c <= b || b + c <= a) {
            return Double.NaN;
        }
        double p = (a + b + c) / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}