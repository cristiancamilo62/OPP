package com.camilo.quiz3.domain;

import com.camilo.phone.domain.Person;

public class Articulos extends Recurso implements Prestable{
    private Person persona;
    public Articulos(String nombre,Person persona) {
        super(nombre);
        this.persona = persona;
    }

    @Override
    public void prestar() {
        this.prestado = true;
    }

    @Override
    public void devolver() {
        this.prestado = false;
    }
}
