package com.camilo.herencia.domain;

public class Teacher extends  Person {
    private String subject;
    private String institution;
    private String classroom;

    public Teacher(String name, String lastName, int age, String subject, String institution, String classroom) {
        super(name, lastName, age);
        this.subject = subject;
        this.institution = institution;
        this.classroom = classroom;
    }

    public String getSubject() {
        return subject;
    }

    public String getInstitution() {
        return institution;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }
}
