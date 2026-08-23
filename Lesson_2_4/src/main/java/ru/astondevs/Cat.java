package ru.astondevs;

public class Cat extends Animal {
    public static int catCount = 0;
    private boolean isFull;

    public Cat(String name) {
        super(name, 200, 0);
        this.isFull = false;
        catCount++;
    }

    public void eat(Bowl bowl, int amount) {
        if (bowl.decreaseFood(amount)) {
            isFull = true;
        }
    }

    public boolean isFull() {
        return isFull;
    }
}
