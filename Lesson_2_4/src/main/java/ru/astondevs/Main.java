package ru.astondevs;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание 1:\n");
        Cat[] cats = {
                new Cat("Уголек"),
                new Cat("Юки"),
                new Cat("Ева"),
                new Cat("Адам"),
        };
        Bowl bowl = new Bowl(0);
        bowl.addFood(5);
        bowl.addFood(5);

        for (Cat cat : cats) {
            cat.eat(bowl, 2);
        }

        System.out.println("В миске осталось: " + bowl.getFoodAmount() + " ед. корма.");

        Dog dog1 = new Dog("Зен");
        Dog dog2 = new Dog("Бен");

        System.out.println("\nВсего животных: " + Animal.animalCount);
        System.out.println("Всего котов: " + Cat.catCount);
        System.out.println("Всего собак: " + Dog.dogCount + "\n");

        cats[0].run(200);
        dog1.run(501);

        cats[1].swim(10);
        dog2.swim(11);

        System.out.println("\nЗадание 2:");
        Shape circle = new Circle(5, "Красный", "Синий");
        Shape rectangle = new Rectangle(4, 8, "Оранжевый", "Фиолетовый");
        Shape triangle = new Triangle(3, 4, 5, "Зеленый", "Желтый");

        circle.printInfo();
        triangle.printInfo();
        rectangle.printInfo();
    }
}