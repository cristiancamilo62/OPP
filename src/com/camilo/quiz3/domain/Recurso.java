package com.camilo.quiz3.domain;

public abstract class Recurso {
    protected boolean prestado;
    private String nombre;
    protected int copias;

    public Recurso(String nombre) {
        this.nombre = nombre;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCopias() {
        return copias;
    }
}
