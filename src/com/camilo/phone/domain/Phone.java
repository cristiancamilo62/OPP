package com.camilo.phone.domain;

public abstract class Phone implements Validate {
    private boolean on;
    private String imei;
    private long number;
    private int capacity;
    private Person dueño;

    public  Phone(String imei, long number, Person dueño) {
        this.imei = imei;
        this.number = number;
        this.dueño = dueño;
    }

    public boolean isOn() {
        return on;
    }

    public String getImei() {
        return imei;
    }

    public long getNumber() {
        return number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}