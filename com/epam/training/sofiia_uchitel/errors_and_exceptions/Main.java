package com.epam.training.sofiia_uchitel.errors_and_exceptions;

import com.epam.training.sofiia_uchitel.errors_and_exceptions.university.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//В университете есть несколько факультетов, в которых учатся студенты, объединенные в группы. У каждого студента есть несколько учебных предметов по которым он получает оценки. Необходимо реализовать иерархию студентов, групп и факультетов.
//
//        Посчитать средний балл по конкретному предмету в конкретной группе и на конкретном факультете
//        Посчитать средний балл по всем предметам студента
//        Посчитать средний балл по предмету для всего университета
//        Реализовать следующие исключения:
//
//        Оценка ниже 0 или выше 10
//        Отсутствие предметов у студента (должен быть хотя бы один)
//        Отсутствие групп на факультете
//        Отсутствие факультетов в университете
//        Отсутствие студентов в группе


public class Main {
    public static void main(String[] args) {
        List<Student> studentList = createStudents();
        System.out.printf("\nСредний балл студента %s с параметрами:\n%s\n%f\n", studentList.get(4).getName() + " " + studentList.get(4).getSurname(), studentList.get(4), studentList.get(4).getAverageGradePoint());

        List<Group> groupList = createGroups(studentList);
        String subjectNameForAverage = "Алгебра";
        System.out.printf("\nСредний балл студентов группы %s по предмету %s с набором студентов:\n%s\n%f\n", groupList.get(0).getName(), subjectNameForAverage, groupList.get(0).getStudents().toString(), groupList.get(0).getAverageGradePointBySubjectName(subjectNameForAverage));

        List<Faculty> facultyList = createFaculty(groupList);
        System.out.printf("\nСредний балл студентов факультета %s по предмету %s с набором студентов:\n%s\n%f\n", facultyList.get(0).getName(), subjectNameForAverage, facultyList.get(0).getStudents().toString(), facultyList.get(0).getAverageGradePointBySubjectName(subjectNameForAverage));

        University university = new University("MyUniversity", new HashSet<>(Arrays.asList(facultyList.get(0), facultyList.get(1))));
        System.out.printf("\nСредний балл студентов университета %s по предмету %s с набором студентов:\n%s\n%f\n", university.getName(), subjectNameForAverage, university.getStudents().toString(), university.getAverageGradePointBySubjectName(subjectNameForAverage));
    }

    public static List<Student> createStudents() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Иван", "Иванов", new HashSet<>(Arrays.asList(new Subject("Алгебра", 10), new Subject("Биология", 5), new Subject("Химия", 5)))));
        studentList.add(new Student("Алексей", "Петров", new HashSet<>(Arrays.asList(new Subject("Алгебра", 8), new Subject("Биология", 5)))));
        studentList.add(new Student("Анна", "Горяева", new HashSet<>(Arrays.asList(new Subject("История", 7), new Subject("Литература", 7), new Subject("Алгебра", 7)))));
        studentList.add(new Student("Антон", "Городецкий", new HashSet<>(Arrays.asList(new Subject("История", 9), new Subject("Экономика", 10), new Subject("Химия", 5)))));
        studentList.add(new Student("Алена", "Андреева", new HashSet<>(Arrays.asList(new Subject("Биология", 7), new Subject("Экономика", 4), new Subject("Химия", 5)))));
        return studentList;
    }

    public static List<Group> createGroups(List<Student> studentList) {
        List<Group> groupList = new ArrayList<>();
        groupList.add(new Group("А", new HashSet<>(Arrays.asList(studentList.get(0), studentList.get(1), studentList.get(2)))));
        groupList.add(new Group("B", new HashSet<>(Arrays.asList(studentList.get(3)))));
        groupList.add(new Group("C", new HashSet<>(Arrays.asList(studentList.get(4)))));
        return groupList;
    }

    public static List<Faculty> createFaculty(List<Group> groupList) {
        List<Faculty> facultyList = new ArrayList<>();
        facultyList.add(new Faculty("F1", new HashSet<>(Arrays.asList(groupList.get(0), groupList.get(1)))));
        facultyList.add(new Faculty("F2", new HashSet<>(Arrays.asList(groupList.get(2)))));
        return facultyList;
    }
}
