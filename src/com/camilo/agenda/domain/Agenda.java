package com.camilo.agenda.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Agenda {
    public static final byte CAPACITY = 50;
    public String name;
    private List<Contact> contacts;

    public Agenda(String name) {
        this.name = name;
        this.contacts = new ArrayList<>();
    }
    public void createContact(Contact contact){
        Contact searchContact = searchContactForNumberOfTelephone(contact.getNumberContact());
        if(this.contacts.size() < CAPACITY && searchContact == null){
            this.contacts.add(contact);
            System.out.println("Contact has been create with successful");
        }
        else{
            System.out.println("Can not add te contact, the number already exist");
        }
    }

    public void deleteContact(String name){
        Contact contactToDelete = searchContactForName(name);
        if(contactToDelete != null){
            this.contacts.remove(contactToDelete);
            System.out.println("Contact hast been deleted");
        }
        else{
            System.out.println("Contact has not been deleted, because it is not found");
        }
    }

    public Contact searchContactForName(String name){
      return this.contacts.stream().
              filter(ct->ct.getName().equals(name)).
              findFirst().orElse(null);
    }

    public Contact searchContactForLastName(String lastName){
        return this.contacts.stream().
                filter(ct->ct.getLastName().equals(lastName)).
                findFirst().orElse(null);
    }

    public Contact searchContactForNumberOfTelephone(String numberOfTelephone){
        return this.contacts.stream().
                filter(ct->ct.getNumberContact().equals(numberOfTelephone)).
                findFirst().orElse(null);
    }
    public void changeNumberOfTelephone(String numberContactOld, String numberContactNew) {
        Contact contactToSearch = searchContactForNumberOfTelephone(numberContactOld);
        if(contactToSearch != null){
            contactToSearch.setNumberContact(numberContactNew);
        }
        else{
            System.out.println("Can not has been found the contact");
        }
    }
    public void sortContactForName(){
        this.contacts.sort(Comparator.comparing(Contact::getName));
    }
    public void sortContactForLastName(){
        this.contacts.sort(Comparator.comparing(Contact::getLastName));
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void showNumbersOfTelephone(){
        for(Contact ct: this.contacts){
            System.out.println("Number of the telephone: " + ct.getNumberContact());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
