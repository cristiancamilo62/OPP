package com.camilo.quiz3.domain;

public class Revista extends Recurso implements Prestable{

    public Revista(String nombre) {
        super(nombre);
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
