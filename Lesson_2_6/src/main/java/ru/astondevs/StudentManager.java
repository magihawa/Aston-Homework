package ru.astondevs;

import java.util.ArrayList;
import java.util.Set;

public class StudentManager {


    public static void removeStudent(ArrayList<Student> students) {
        students.removeIf(Student::shouldBeExcluded);
    }

    public static void advanceStudent(ArrayList<Student> students) {
        for (Student s : students) {
            s.ascendCourse();
        }
        students.removeIf(s -> s.getCourse() > s.getMaxCourse());
    }

    public static void printStudents(Set<Student> students, int course) {
        System.out.println("\nСтуденты " + course + " курса:");
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println("Имя студента: " + student.getName());
            }
        }
    }
}
