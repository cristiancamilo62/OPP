package com.camilo.phone.domain;

public class BasicPhone extends Phone implements Validate {
    private int code;

    public BasicPhone(String imei, long number, Person person) {
        super(imei, number, person);
        this.code = person.getCode();
    }


    @Override
    public Boolean validate(Person person) {

        return this.code == person.getCode();
    }
}
