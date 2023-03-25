package com.camilo.snacksmachine.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SnackMachine {
    public static final byte MACHINE_CAPACITY = 12;
    public static final byte CAPACITY_SNACKS = 6;
    private String name;
    private List<Snack> snacks;
    private int amountSnake;

    public SnackMachine(String name) {

        this.name = name;
        this.snacks = new ArrayList<Snack>();
    }

    public void addSnake(Snack snack) {
        Snack snackToAddCode = searchSnackForCode(snack.getCode());
        if (this.snacks.size() < MACHINE_CAPACITY && snackToAddCode == null) {
            this.snacks.add(snack);
            System.out.println("successful add");
        } else {
            System.out.println("Could not add the snack");
        }

    }

    public void takeOutSnackByCode(String code) {
        if (searchSnackForCode(code) != null && this.searchSnackForCode(code).getUnits()-1 >= 0) {
            searchSnackForCode(code).setUnits(searchSnackForCode(code).getUnits()-1);
            System.out.println("Successful buy");
        } else {
            System.out.println("Failed buy");
        }
    }

    public void takeOutSnackForName(String name) {
        if (searchSnackForName(name) != null && this.searchSnackForName(name).getUnits()-1 >= 0) {
            searchSnackForName(name).setUnits(searchSnackForName(name).getUnits() - 1);
            System.out.println("Successful buy");
        } else {
            System.out.println("Failed buy");
        }
    }

    public Snack searchSnackForName(String name) {
        return this.snacks.stream().
                filter(sk -> sk.getName().equals(name)).
                findFirst().orElse(null);
    }

    public void increaseAmountTheSnack(int units, String code) {
        if (searchSnackForCode(code) != null && this.searchSnackForCode(code).getUnits() + units <= 6) {
            searchSnackForCode(code).setUnits(searchSnackForCode(code).getUnits() + units);
            System.out.println("Snacks add with successful");
        } else {
            System.out.println("Can not add so many snacks");
        }
    }

    public void deleteSnackByCode(String code) {
        if (searchSnackForCode(code) != null) {
            this.snacks.remove(searchSnackForCode(code));
            System.out.println("has been successfully removed");
        } else {
            System.out.println("Don't has been found the snack");
        }
    }

    public Snack searchSnackForCode(String code) {
        return this.snacks.stream().
                filter(sk -> sk.getCode().equals(code)).
                findFirst().orElse(null);
    }

    public void getUnitsOfTheSnakeDeterminate(String code) {
        Snack snackShow = searchSnackForCode(code);
        if (snackShow != null) {
            System.out.println("name: " + snackShow.getName() + "\nUnits: " + snackShow.getUnits());
        } else {
            System.out.println("This snack doesn't exist in the machine");
        }

    }

    public List<String> getNameSnakesSoldOutStock() {
        List<String> soldOutStock = new ArrayList<>();
        for (Snack sk : this.snacks) {
            if (sk.getUnits() == 0)
                soldOutStock.add(sk.getName());
        }
        return soldOutStock;
    }

    public void getNameAndUnitsOfTheSnack() {
        for (Snack sk : this.snacks) {
            System.out.println("name: " + sk.getName() + "\nUnits: " + sk.getUnits());
        }
    }

    public void sortedTheHighToLowest() {
        this.snacks.sort(Comparator.comparing(Snack::getPrice));
    }

    public void sortTheLowestToHigh() {
        this.snacks.sort(Comparator.comparing(Snack::getUnits).reversed());
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmountSnake() {
        return amountSnake;
    }

    public void setAmountSnake(int amountSnake) {
        this.amountSnake = amountSnake;
    }

    public List<Snack> getSnacks() {
        return snacks;
    }

}
