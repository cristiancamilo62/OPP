package com.camilo.telephony.domain;

public class Person {
    private String name;
    private int Age;
    private int Id;
    private String Lastname;

    public Person(String name, int id, String lastname) {
        this.name = name;
        this.Id = id;
        this.Lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return Age;
    }

    public int getId() {
        return Id;
    }

    public String getLastName() {
        return Lastname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastname) {
        Lastname = lastname;
    }
}
