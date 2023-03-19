package com.camilo.telephony.domain;

public class Contact {
    private String numberContact;
    private Person person;

    public Contact (String numberContact){
        this.numberContact =  numberContact;
    }

    public String getNumberContact() {
        return numberContact;
    }

    public void setNumberContact(String numberContact) {
        this.numberContact = numberContact;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person persons) {
        this.person = person;
    }
}
