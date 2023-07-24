package com.camilo.quiz3.domain;

public class Libro extends Recurso implements Copiable,Prestable{


    public Libro(String nombre) {
        super(nombre);
    }

    @Override
    public void fotocopiar() {
        this.copias++;
    }

    @Override
    public void prestar() {
        this.prestado= true;
    }

    @Override
    public void devolver() {
        this.prestado = false;
    }
}
