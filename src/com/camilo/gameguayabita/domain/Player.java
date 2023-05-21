package com.camilo.gameguayabita.domain;

import javax.swing.*;
import java.util.List;
import java.util.Random;

import static com.camilo.gameguayabita.domain.Guayabita.*;

public class Player {
    public static final short INITIAL_STAKE = 500;
    private String name;
    private double money;


    public Player(String name,double money) {
        this.name = name;
        this.money = money;
    }
    public  int rollDie() {
        int randomNumber = 0;
        Random random = new Random();

        // Generar un número aleatorio entre 0 y 100
        randomNumber = random.nextInt(7);
        return randomNumber;
    }
    public double bet(double moneyToTheBet){
        double moneyOfBet = 0;
        boolean puedeContinuar = false;
        int desicion = (int) JOptionPane.showConfirmDialog(null, "Quieres apostar "+this.getName(), APP_TITLE, JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE,APP_ICON);

        do {
            if(desicion == JOptionPane.YES_OPTION) {
                String money = (String) JOptionPane.showInputDialog(null,
                        name + ",¿cuánto quiere apostar?.\n\nla apuesta esta en: " + moneyToTheBet, APP_TITLE, JOptionPane.YES_OPTION, APP_ICON, null, "");
                if (money == null || (money.isEmpty())) {
                    JOptionPane.showMessageDialog(null, "La celda no puede estar vacia", APP_TITLE, JOptionPane.INFORMATION_MESSAGE, APP_ICON);
                } else if (!money.matches("[0-9]+")) {
                    JOptionPane.showMessageDialog(null, "El valor a ingresar debe ser numerico", APP_TITLE, JOptionPane.INFORMATION_MESSAGE, APP_ICON);
                } else {
                    moneyOfBet = Double.valueOf(money);
                    if (this.getMoney() - moneyOfBet >= 0 && moneyOfBet <= moneyToTheBet) {
                        puedeContinuar = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "debe ser menor la cantidad", APP_TITLE, JOptionPane.INFORMATION_MESSAGE, APP_ICON);
                        puedeContinuar = false;
                    }
                }
            }
            else{
                moneyOfBet = 0;
                puedeContinuar = true;
            }
        }while (!puedeContinuar);
        return moneyOfBet;
    }


    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
