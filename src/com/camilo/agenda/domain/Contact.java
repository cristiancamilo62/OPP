package com.camilo.agenda.domain;

public class Contact {
    private String numberContact;
    private String name;
    private String lastName;

    public Contact(String name, String lastName, String numberContact) {
        this.numberContact = numberContact;
        this.name = name;
        this.lastName = lastName;
    }

    public String getNumberContact() {
        return numberContact;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setNumberContact(String numberContact) {
        this.numberContact = numberContact;
    }
}


