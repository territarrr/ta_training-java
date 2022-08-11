package com.epam.training.sofiia_uchitel.errors_and_exceptions;

import com.epam.training.sofiia_uchitel.errors_and_exceptions.exception.FacultetsCountException;

import java.util.ArrayList;
import java.util.HashSet;

public class University {
    private final String name;
    private HashSet<Faculty> faculties;

    public University(String name, HashSet<Faculty> faculties) {
        this.name = name;
        setFaculties(faculties);
    }

    public String getName() {
        return name;
    }

    public HashSet<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(HashSet<Faculty> faculties) {
        if (faculties.isEmpty()) {
            throw new FacultetsCountException("В университете должен быть хотя бы один факультет.");
        } else {
            this.faculties = faculties;
        }
    }

    //Получить всех студентов унивепситета
    public HashSet<Student> getStudents() {
        HashSet<Student> students = new HashSet<>();
        for (Faculty faculty :
                faculties) {
            students.addAll(faculty.getStudents());
        }

        return students;
    }

    //Посчитать суммарный балл по конкретному предмету для всего университета
    public int getSumGradeBySubjectName(String subjectName) {
        int sumGradePointBySubjectName = 0;
        for (Faculty faculty :
                faculties) {
            sumGradePointBySubjectName += faculty.getSumGradeBySubjectName(subjectName);
        }
        return sumGradePointBySubjectName;
    }

    //Подсчитать количество студентов изучаюших предмет для всего университета
    public int getStudentsCountLearningSubject(String subjectName) {
        int studentsCount = 0;
        for (Faculty faculty :
                faculties) {
            studentsCount += faculty.getStudentsCountLearningSubject(subjectName);
        }
        return studentsCount;
    }

    //Посчитать средний балл по предмету для всего университета
    public double getAverageGradePointBySubjectName(String subjectName) {
        return (double) getSumGradeBySubjectName(subjectName) / getStudentsCountLearningSubject(subjectName);
    }

}
