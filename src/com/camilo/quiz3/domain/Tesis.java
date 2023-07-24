package com.camilo.quiz3.domain;

public class Tesis extends Recurso implements Copiable{

    public Tesis(String nombre) {
        super(nombre);
    }

    @Override
    public void fotocopiar() {
        this.copias++;
    }
}
