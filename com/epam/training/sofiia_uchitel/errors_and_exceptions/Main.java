package com.epam.training.sofiia_uchitel.errors_and_exceptions;

import java.util.Arrays;
import java.util.HashSet;

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
        Student student1 = new Student("Иван", "Иванов", new HashSet<>(Arrays.asList(
                new Subject("Алгебра", 10),
                new Subject("Биология", 5),
                new Subject("Химия", 5)
        )));

        Student student2 = new Student("Алексей", "Петров", new HashSet<>(Arrays.asList(
                new Subject("Алгебра", 8),
                new Subject("Биология", 5)
        )));

        Student student3 = new Student("Анна", "Горяева", new HashSet<>(Arrays.asList(
                new Subject("История", 7),
                new Subject("Литература", 7),
                new Subject("Алгебра", 7)
        )));

        Student student4 = new Student("Антон", "Городецкий", new HashSet<>(Arrays.asList(
                new Subject("История", 9),
                new Subject("Экономика", 10),
//                new Subject("Алгебра", 6),
                new Subject("Химия", 5)
        )));

        Student student5 = new Student("Алена", "Андреева", new HashSet<>(Arrays.asList(
                new Subject("Биология", 7),
                new Subject("Экономика", 4),
                new Subject("Химия", 5)
        )));

        System.out.printf("\nСредний балл студента %s с параметрами:\n%s\n%f\n", student5.getName() +" "+ student5.getSurname(), student5, student5.getAverageGradePoint());

        Group group1 = new Group("А", new HashSet<>(Arrays.asList(student1, student2, student2, student3)));
        Group group2 = new Group("B", new HashSet<>(Arrays.asList(student4)));
        Group group3 = new Group("C", new HashSet<>(Arrays.asList(student5)));

        String subjectNameForAverage = "Алгебра";

        System.out.printf("\nСредний балл студентов группы %s по предмету %s с набором студентов:\n%s\n%f\n", group1.getName(), subjectNameForAverage, group1.getStudents().toString(), group1.getAverageGradePointBySubjectName(subjectNameForAverage));

        Faculty faculty1 = new Faculty("F1", new HashSet<>(Arrays.asList(group1, group2)));
        Faculty faculty2 = new Faculty("F2", new HashSet<>(Arrays.asList(group3)));

        System.out.printf("\nСредний балл студентов факультета %s по предмету %s с набором студентов:\n%s\n%f\n", faculty1.getName(), subjectNameForAverage, faculty1.getStudents().toString(), faculty1.getAverageGradePointBySubjectName(subjectNameForAverage));

        University university = new University("MyUniversity", new HashSet<>(Arrays.asList(faculty1, faculty2)));

        System.out.printf("\nСредний балл студентов университета %s по предмету %s с набором студентов:\n%s\n%f\n", university.getName(), subjectNameForAverage, university.getStudents().toString(), university.getAverageGradePointBySubjectName(subjectNameForAverage));
    }
}
