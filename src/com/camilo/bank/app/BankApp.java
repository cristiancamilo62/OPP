package com.camilo.bank.app;

import com.camilo.bank.domain.Bank;
import com.camilo.bank.domain.BankAccount;
import com.camilo.bank.domain.Person;

import java.util.ArrayList;
import java.util.Scanner;

public class BankApp {
    //
    public static void dataPersonal(){
        for(Person per: bankAccounts){
            System.out.println(per.toString());
            System.out.println("\n");
        }
    }
    static ArrayList<Person> bankAccounts = new ArrayList<Person>();
    static  Scanner dataInput = new Scanner(System.in);


        public static void main(String[] args){

            //creacion de variables
            int maximumClients = 0;
            String verification = "";
            String name;
            int id;
            String surname;
            int age;
            int clientPosition = 0;
            double moneyToWithdrawal;
            double moneyToDeposit;


            //instanciar objetos....
            Bank bank = new Bank();
            BankAccount myAccount = new BankAccount();
            myAccount.bank = bank;

            while (!"FINISH".equals(verification)) {
                System.out.println(myAccount.bank.bankMenu());
                verification = dataInput.nextLine().toUpperCase();
                if ("1".equals(verification)) {
                    System.out.println("Enter your name");
                    name = dataInput.nextLine();

                    System.out.println("Enter your surname");
                    surname = dataInput.nextLine();

                    System.out.println("Enter your age");
                    age = dataInput.nextInt();

                    System.out.println("enter your id");
                    id = dataInput.nextInt();
                    dataInput.nextLine();

                    Person person1 = new Person(name, surname, age, id);
                    myAccount.holder = person1;
                    myAccount.isActive = true;

                    bankAccounts.add(myAccount.holder);
                    maximumClients++;
                    myAccount.bank.setMaximumClients(maximumClients);
                } else if ("2".equals(verification)) {
                    dataPersonal();
                    System.out.println("Press enter to continue");
                    dataInput.nextLine();

                } else if ("3".equals(verification)) {
                    System.out.println(myAccount.balance);
                }
                else if ("4".equals(verification)) {
                    System.out.println("Enter money to deposit");
                    moneyToDeposit = dataInput.nextDouble();
                    myAccount.deposit(moneyToDeposit);
                    dataInput.nextLine();
                }
                else if("5".equals(verification)){
                    System.out.println("Enter money to withdraw");
                    moneyToWithdrawal = dataInput.nextDouble();
                    myAccount.withdrawal(moneyToWithdrawal);
                }
            }
        }
    }



