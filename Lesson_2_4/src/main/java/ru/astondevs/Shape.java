package ru.astondevs;

public interface Shape extends Colorable {
    String getName();

    double getPerimeter();

    double getArea();

    default void printInfo() {
        System.out.println("Фигура: " + getName());
        System.out.println("Периметр: " + getPerimeter());
        System.out.println("Площадь: " + getArea());
        System.out.println("Цвет фона: " + getFillColor());
        System.out.println("Цвет границ: " + getBorderColor() + "\n");
    }
}
