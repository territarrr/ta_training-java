package com.epam.training.sofiia_uchitel.errors_and_exceptions.university;

import com.epam.training.sofiia_uchitel.errors_and_exceptions.exception.GroupCountException;

import java.util.HashSet;
import java.util.Objects;

public class Faculty {
    private final String name;
    private HashSet<Group> groups;

    public Faculty(String name, HashSet<Group> groups) {
        this.name = name;
        if (groups.isEmpty()) {
            throw new GroupCountException("На факультете должна быть хотя бы одна группа.");
        } else {
            this.groups = groups;
        }
    }

    public String getName() {
        return name;
    }

    public HashSet<Group> getGroups() {
        return groups;
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    //Получить всех студентов факультета
    public HashSet<Student> getStudents() {
        HashSet<Student> students = new HashSet<>();
        for (Group group :
                groups) {
            students.addAll(group.getStudents());
        }
        return students;
    }

    //Посчитать суммарный балл по конкретному предмету на конкретном факультете
    public int getSumGradeBySubjectName(String subjectName) {
        int sumGradePointBySubjectName = 0;
        for (Group group :
                groups) {
            sumGradePointBySubjectName += group.getSumGradeBySubjectName(subjectName);
        }
        return sumGradePointBySubjectName;
    }

    //Подсчитать количество студентов изучаюших предмет
    public int getStudentsCountLearningSubject(String subjectName) {
        int studentsCount = 0;
        for (Group group :
                groups) {
            studentsCount += group.getStudentsCountLearningSubject(subjectName);
        }
        return studentsCount;
    }

    //Посчитать средний балл по конкретному предмету на конкретном факультете
    public double getAverageGradePointBySubjectName(String subjectName) {
        return (double) getSumGradeBySubjectName(subjectName) / getStudentsCountLearningSubject(subjectName);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                ", groups=" + groups.toString() +
                '}';
    }

    //Проверка равенства объектов по имени hashSet
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(name, faculty.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
