package com.epam.training.sofiia_uchitel.errors_and_exceptions;

import com.epam.training.sofiia_uchitel.errors_and_exceptions.exception.SubjectCountException;

import java.util.HashSet;
import java.util.Objects;


public class Student {
    private String name;
    private String surname;
    private HashSet<Subject> subjects;

    public Student(String name, String surname, HashSet<Subject> subjects) {
        this.name = name;
        this.surname = surname;
        setSubjects(subjects);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public HashSet<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(HashSet<Subject> subjects) {
        if (subjects.isEmpty()) {
            throw new SubjectCountException("У студента должен быть хотя бы один предмет!");
        } else {
            this.subjects = subjects;
        }
    }

    //Изучает ли студент предмет
    public boolean doesStudentLearn(String subjectName) {
        for (Subject subject : subjects) {
            if (subjectName.equals(subject.getName())) return true;
        }
        return false;
    }

    //Посчитать средний балл по всем предметам студента
    public double getAverageGradePoint() {
        int gradeSum = 0;
        for (Subject subject : subjects) {
            gradeSum += subject.getGrade();
        }
        return (double) gradeSum / subjects.size();
    }

    //Получить балл студента по конкретному предмету
    public int getGradeBySubjectName(String subjectName) {
        Subject foundSubject = null;
        for (Subject subject : subjects) {
            if (subjectName.equals(subject.getName())) {
                foundSubject = subject;
            }
        }
        if (Objects.isNull(foundSubject)) {
            return 0;
        } else {
            return foundSubject.getGrade();
        }
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", surname='" + surname + '\'' + ", subjects=" + subjects + '}';
    }

    //Проверка равенства объектов по имени и фамилии для hashSet
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }
}
