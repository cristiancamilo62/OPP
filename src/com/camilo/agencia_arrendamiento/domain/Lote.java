package com.camilo.agencia_arrendamiento.domain;

public class Lote extends Inmueble{

    public Lote(String direccion, long valorVenta) {
        super(direccion, valorVenta);
    }

    @Override
    public String toString() {
        return "Lote{" +
                super.toString();
    }
}
