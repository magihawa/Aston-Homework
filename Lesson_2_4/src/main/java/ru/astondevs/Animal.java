package ru.astondevs;

public class Animal {

    private String name;
    private int maxRunDistance;
    private int maxSwimDistance;
    public static int animalCount = 0;

    public String getName() {
        return name;
    }

    public Animal(String name, int maxRunDistance, int maxSwimDistance) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        animalCount++;
    }

    public void run(int distance) {
        if (maxRunDistance == 0) {
            System.out.println(name + " не умеет бегать.");
        } else if (distance < 0) {
            System.out.println("Расстояние не может быть отрицательным");
        } else if (distance > maxRunDistance) {
            System.out.println(
                    name + " не смог пробежать " + distance + " м.");
        } else {
            System.out.println(name + " пробежал " + distance + " м.");
        }
    }

    public void swim(int distance) {
        if (maxSwimDistance == 0) {
            System.out.println(name + " не умеет плавать.");
        } else if (distance < 0) {
            System.out.println("Расстояние не может быть отрицательным");
        } else if (distance > maxSwimDistance) {
            System.out.println(name + " не смог проплыть " + distance + " м.");
        } else {
            System.out.println(name + " проплыл " + distance + " м.");
        }
    }
}