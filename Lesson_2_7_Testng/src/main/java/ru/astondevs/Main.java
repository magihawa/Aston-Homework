package ru.astondevs;

import static ru.astondevs.Calculator.*;
import static ru.astondevs.Factorial.calculateFactorial;
import static ru.astondevs.IntCompare.compareInts;
import static ru.astondevs.TriangleArea.getTriangleArea;

public class Main {
    public static void main(String[] args) {
        System.out.println(calculateFactorial(4));
        System.out.println(getTriangleArea(5,5,5));
        System.out.println(add(5,5));
        System.out.println(subtract(5,5));
        System.out.println(multiply(5,5));
        System.out.println(divide(5,5));
        System.out.println(compareInts(5,5));
    }
}