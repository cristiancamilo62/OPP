package com.camilo.car.domain;

public class Person {
    public String name;
    public int id;
    public String surname;
    public int age;

    public Person(String name, String surname, int age, int id){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Personal data\n" +
                "name: " + name +
                "\nid: " + id +
                "\nsurname: " + surname +
                "\nage: " + age;
    }
}
