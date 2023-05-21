package com.camilo.nomina.domain;

public abstract  class Empleado {
    private String nombre;

    public Empleado(String nombre){
        this.nombre = nombre;
    }
    public abstract long calcularSalario();

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "nombre{" +
                 nombre +
                "}" ;
    }

}
