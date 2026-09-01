package ru.astondevs;

import java.util.List;

public class Student {
    private String name;
    private int group;
    private int course;
    private List<Integer> grades;
    private static final int MAX_COURSE = 5;

    public Student(String name, int group, int course, List<Integer> grades) {
        if (course < 1 || course > MAX_COURSE) {
            throw new IllegalArgumentException("Курс должен быть от 1 до " + MAX_COURSE);
        }
        if (grades != null) {
            for (Integer grade :
                    grades) {
                if (grade < 1 || grade > 5) {
                    throw new IllegalArgumentException("Оценка не может быть меньше 1 или больше 5");
                }
            }
        }

        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public double getAvgGrade() {
        int sum = 0;
        if (grades == null || grades.isEmpty()) {
            return 0;
        }
        for (Integer grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    public boolean shouldBeExcluded() {
        return getAvgGrade() < 3;
    }

    public void ascendCourse() {
        if (getAvgGrade() >= 3) {
            course++;
        }
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    public int getMaxCourse() {
        return MAX_COURSE;
    }
}

