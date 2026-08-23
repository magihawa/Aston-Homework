package ru.astondevs;

public class Bowl {
    private int food;

    public Bowl(int food) {
        this.food = Math.max(food, 0);
    }

    public void addFood(int foodCount) {
        if (foodCount > 0) {
            food += foodCount;
            System.out.println("В миску добавлено " + foodCount + " ед. корма. Теперь в миске " + food + " ед. корма.");
        } else {
            System.out.println("В миску нельзя добавить отрицательное количество или ноль единиц корма.");
        }
    }

    public boolean decreaseFood(int foodCount) {
        if (foodCount > food || foodCount <= 0) {
            return false;
        }
        food -= foodCount;
        return true;
    }

    public int getFoodAmount() {
        return food;
    }
}

