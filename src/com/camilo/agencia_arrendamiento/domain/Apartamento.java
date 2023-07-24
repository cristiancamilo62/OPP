package com.camilo.agencia_arrendamiento.domain;

public class Apartamento extends Inmueble implements Arrendable{
    private long valorArriendo;

    public Apartamento(String direccion, long valorVenta, long valorArriendo) {
        super(direccion, valorVenta);
        this.valorArriendo = valorArriendo;
    }

    @Override
    public void arrendar() {
        this.arrendado = true;
    }

    @Override
    public void devolver() {
        this.arrendado = false;
    }

    @Override
    public String toString() {
        return "Apartamento{" +
                "valorArriendo=" + valorArriendo +
                ", arrendado=" + arrendado +
                ", "+super.toString();
    }
}
