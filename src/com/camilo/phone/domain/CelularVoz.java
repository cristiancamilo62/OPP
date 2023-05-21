package com.camilo.phone.domain;

public class CelularVoz extends BasicPhone implements Validate{
    private String voz;

    public CelularVoz(String imei, long number, Person person) {
        super(imei, number,person);
        this.voz = person.getVoz();
    }

    @Override
    public Boolean validate(Person person) {
        if(this.voz.equals(person.getVoz())){
            return true;
        }
        System.out.println("Validacion de vos incorrecta");
        return super.validate(person);
    }
}
