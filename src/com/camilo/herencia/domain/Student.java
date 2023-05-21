package com.camilo.herencia.domain;

import java.util.List;

public class Student extends Person{
    private List<Subject> subjects;
    private String institution;

    public Student(String name, String lastName, int age, String institution) {
        super(name, lastName, age);
        this.institution = institution;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public String getInstitution() {
        return institution;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }
}
