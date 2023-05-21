package com.camilo.phone.domain;

public class CelularCara extends  BasicPhone implements  Validate{
    private String cara;

    public CelularCara(String imei, long number, String brand, Person person, String cara) {
        super(imei, number, person);
        this.cara = cara;
    }

    @Override
    public Boolean validate(Person person) {
        if(this.cara.equals(person.getRostro())){
            return true;
        }
        System.out.println("validacion de rostro incorrecta");
        return super.validate(person);
    }
}
