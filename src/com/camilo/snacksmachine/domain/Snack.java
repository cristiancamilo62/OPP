package com.camilo.snacksmachine.domain;

public class Snack {
    private String name;
    private String code;
    private int Units;
    private double price;

    public Snack(String name, String code, double price) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.Units++;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getUnits() {
        return Units;
    }

    public double getPrice() {
        return price;
    }

    public void setUnits(int units) {
        Units = units;
    }

}
