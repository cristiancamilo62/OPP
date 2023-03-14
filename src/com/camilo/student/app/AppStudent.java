package com.camilo.student.app;

import com.camilo.student.domain.Institution;
import com.camilo.student.domain.Student;

public class AppStudent {
    public static void main(String[] args) {
        Institution institution = new Institution();
        Student student1 = new Student();

        student1.institution = institution;
        student1.institution.studentAmount++;
        student1.name = "camilo";
        student1.age = 19;

        Student student2 = new Student();
        student2.institution = institution;
        student2.institution.studentAmount++;

        student2.name = "laura";
        student2.studyYears = 3;
        student2.grade = 3;

        System.out.println(student1.toString());
        System.out.println(student1.institution.getStudentAmount());
        System.out.println("");

        System.out.println(student2.toString());
        System.out.println(student2.institution.getStudentAmount());
    }
}
