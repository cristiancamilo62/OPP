package com.camilo.student.domain;

public class Student {
    public String name;
    public String lastName;
    public int age;
    public int grade;
    public float height;
    public Institution institution;
    public int studyYears;
    public int studentId;
    public int classHours;

    public void updateYearsStudy(int studyYears){
        this.studyYears = studyYears;
    }
    public int getId(){
        return studentId;
    }
    public int getStudyYears(){
        return studyYears;
    }

    @Override
    public String toString() {
        return "name: " + name +
                "\nlastName: " + lastName +
                "\nage: " + age +
                "\ngrade: " + grade +
                "\nheight: " + height +
                "\nstudyYears: " + studyYears +
                "\nstudentId: " + studentId +
                "\nclassHours: " + classHours;
    }
}
