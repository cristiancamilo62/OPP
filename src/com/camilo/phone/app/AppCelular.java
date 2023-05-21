package com.camilo.phone.app;

import com.camilo.phone.domain.*;

import java.util.ArrayList;
import java.util.List;

public class AppCelular {
    public static void main(String[] args) {
        Person andres = new Person("andres","holis","huella1","xxc",111,"Holis");
        Person Juan = new Person("Juan","h","p","dsf",34,"jsdk");
        List<Phone> phones = new ArrayList<>();

        phones.add(new CelularVoz("1",112,andres));

        phones.forEach(phone -> {
            if(phone instanceof Validate){
                System.out.println(phone.validate(Juan));
            }
        });

    }
}
