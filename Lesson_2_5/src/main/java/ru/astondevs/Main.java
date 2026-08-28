package ru.astondevs;


public class Main {

    public static void main(String[] args) {
        String[][] array = new String[4][4];

        array[0] = new String[]{"1", "2", "3", "4"};
        array[1] = new String[]{"5", "6", "7", "8"};
        array[2] = new String[]{"9", "10", "11", "12"};
        array[3] = new String[]{"13", "14", "15", "16"};

        try {
            int result = sumArray(array);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных: " + e.getMessage());
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера: " + e.getMessage());
        }

        try {
            int[] test = new int[3];
            System.out.println(test[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Получили ArrayIndexOutOfBoundsException " + e.getMessage());
        }
    }

    public static int sumArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (array.length != 4) {
            throw new MyArraySizeException("Количество строк не равно 4");
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Строка " + i + " имеет длину " + array[i].length);

            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    int value = Integer.parseInt(array[i][j]);
                    sum += value;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Ошибка в ячейке [" + i + "][" + j + "]: значение '" + array[i][j] + "' не является целым числом.");
                }
            }
        }
        return sum;
    }
}