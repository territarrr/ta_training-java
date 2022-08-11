package com.epam.training.sofiia_uchitel.errors_and_exceptions;

import com.epam.training.sofiia_uchitel.errors_and_exceptions.exception.StudentsCountException;

import java.util.HashSet;
import java.util.Objects;

public class Group {
    private final String name;
    private HashSet<Student> students;

    public Group(String name, HashSet<Student> students) {
        this.name = name;
        setStudents(students);
    }

    public String getName() {
        return name;
    }

    public HashSet<Student> getStudents() {
        return students;
    }

    public void setStudents(HashSet<Student> students) {
        if (students.isEmpty()) {
            throw new StudentsCountException("В группе должен быть хотя бы один студент.");
        } else {
            this.students = students;
        }
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    //Посчитать суммарный балл по конкретному предмету в конкретной группе
    public int getSumGradeBySubjectName(String subjectName) {
        int sumGradePointBySubjectName = 0;
        for (Student student :
                students) {
            sumGradePointBySubjectName += student.getGradeBySubjectName(subjectName);
        }
        return sumGradePointBySubjectName;
    }

    //Подсчитать количество студентов изучаюших предмет
    public int getStudentsCountLearningSubject(String subjectName){
        int studentsCount = 0;
        for (Student student:
             students) {
            if(student.doesStudentLearn(subjectName))
                studentsCount++;
        }
        return studentsCount;
    }

    //Посчитать средний балл по конкретному предмету в конкретной группе
    public double getAverageGradePointBySubjectName(String subjectName) {
        return (double) getSumGradeBySubjectName(subjectName) / getStudentsCountLearningSubject(subjectName);
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", students=" + students.toString() +
                '}';
    }

    //Проверка равенства объектов по имени hashSet
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(name, group.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
