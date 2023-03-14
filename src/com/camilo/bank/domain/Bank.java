package com.camilo.bank.domain;

public class Bank {
    public String name = "Bancolombia";
    public String accountType;
    public int maximumClients;

    public String bankMenu(){
        return "1. Happen client:" +
                "\n2. Show personal client data "+
                "\n3. Show balance of the client"+
                "\n4. Deposit money"+
                "\n5. withdraw money"+
                "\n6. Change bank account key"+
                "\n\nEnter finish to close program";
    }

    public int getMaximumClients() {
        return maximumClients;
    }

    public void setMaximumClients(int maximumClients) {
        this.maximumClients = maximumClients;
    }
}
