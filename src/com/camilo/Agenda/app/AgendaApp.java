package com.camilo.Agenda.app;

import com.camilo.Agenda.domain.Contact;
import com.camilo.Agenda.domain.Agenda;

import java.util.Scanner;


public class AgendaApp {

    public static void main(String[] args) {
        menu();
    }
    public static void menu(){
        Scanner scanner=new Scanner(System.in);
        Agenda agenda=new Agenda("Agenda");
        String decision;
        boolean aux=true;
        do {
            System.out.println("write:\n1. to create new contact\n2. to delete contact\n3. to search by name" +
                    "\n4. to search by last name\n5. to search by cellphone number\n6. to change cellphone number" +
                    "\n7. to sort contacts by name\n8. to sort contacts by last name\n9. to show cellphone of contacts" +
                    "\n10. to finalize");
            decision=scanner.next();
            switch (decision){
                case "1":
                    System.out.println("Write the name, last name and cellphone number");
                    String name=scanner.next();
                    String lastName=scanner.next();
                    String cellphoneNumber=scanner.next();
                    Contact ct1=new Contact(name,lastName,cellphoneNumber);
                    agenda.createContact(ct1);
                    break;
                case "2":
                    System.out.println("write the cellphone of the contact");
                    cellphoneNumber=scanner.next();
                    agenda.deleteContact(cellphoneNumber);
                    break;
                case "3":
                    System.out.println("write the name");
                    name=scanner.next();
                    agenda.searchContactForName(name);
                    break;
                case "4":
                    System.out.println("write the last name");
                    lastName=scanner.next();
                    agenda.searchContactForLastName(lastName);
                    break;
                case "5":
                    System.out.println("write the cellphone number");
                    cellphoneNumber=scanner.next();
                    agenda.searchContactForNumberOfTelephone(cellphoneNumber);
                    break;
                case "6":
                    System.out.println("write the old cellphone number of the contact and the new cellphone number");
                    cellphoneNumber=scanner.next();
                    String newCellphoneNumber=scanner.next();
                    agenda.changeNumberOfTelephone(cellphoneNumber,newCellphoneNumber);
                    break;
                case "7":
                    agenda.sortContactForName();
                    break;
                case "8":
                    agenda.sortContactForLastName();
                    break;
                case "9":
                    agenda.showNumbersOfTelephone();
                    break;
                case "10":
                    System.out.println("Program finalized");
                    aux=false;
                    break;
                default:
                    System.out.println("choose a correct option");
            }
        }while (decision!="10" && aux);
    }
}
