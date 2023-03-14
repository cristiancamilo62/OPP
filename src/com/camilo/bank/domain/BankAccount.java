package com.camilo.bank.domain;

public class BankAccount {
    public Person holder;
    public Bank bank;
    public double balance;
    public boolean isActive;
    public int movementsDeposit = 0;
    public int movementsWithdrawal = 0;
    public int movementsTransfer = 0;


    public void deposit(double moneyToDeposit){
        if(this.isActive){
            this.balance += moneyToDeposit;
            this.movementsDeposit++;
            System.out.println("successful deposit");
        }else{
            System.out.println("Deposit failed.\nThe account is inactive. Try again");
        }
    }

    public void withdrawal(double moneyToWithdrawal){
        if(this.balance >= moneyToWithdrawal && this.isActive) {
            this.balance -= moneyToWithdrawal;
            System.out.println(this.holder.name +" his withdrawal has been successful");
            movementsWithdrawal++;
        }
        else{
            System.out.println(this.holder.name + " his withdrawal has been failed");
        }
    }

    public void transfer(double moneyToTransfer){
        if(this.balance >= moneyToTransfer && this.isActive){
            withdrawal(moneyToTransfer);

        }
        else{

        }

    }

    @Override
    public String toString() {
        return "Bank Account data:" +
                "balance: " + balance +
                "isActive: " + isActive +
                "movementsDeposit: " + movementsDeposit +
                "movementsWithdrawal: " + movementsWithdrawal +
                "movementsTransfer: " + movementsTransfer;
    }
}
