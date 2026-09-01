package ru.astondevs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import static ru.astondevs.StudentManager.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<Student>(List.of(
                new Student("Петр", 1, 4, List.of(4, 4, 5)),
                new Student("Василий", 1, 4, List.of(1, 1, 3)),
                new Student("Дмитрий", 1, 4, List.of(2, 3, 3))
        )
        );

        printStudents(new HashSet<>(students), 4);
        removeStudent(students);

        advanceStudent(students);
        printStudents(new HashSet<>(students), 5);

        System.out.println("\nЗадание 2: ");
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "+7-999-123-45-67");
        phoneBook.add("Иванов", "+7-999-123-45-68");
        phoneBook.add("Петров", "+7-911-987-65-43");

        System.out.println(phoneBook.getPhones("Иванов"));
    }


}