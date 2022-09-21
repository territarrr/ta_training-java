package com.epam.training.sofiia_uchitel.errors_and_exceptions.university;

import com.epam.training.sofiia_uchitel.errors_and_exceptions.exception.GradeException;

import java.util.Objects;

public class Subject {
    private final String name;
    private int grade;

    public Subject(String name, int grade) throws GradeException {
        this.name = name;
        if (grade < 0 || grade > 10) {
            throw new GradeException("Оценка должна быть от 0 до 10!");
        }
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return name +" - " + grade;
    }

    //Проверка равенства объектов по имени для hashSet
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return Objects.equals(name, subject.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
