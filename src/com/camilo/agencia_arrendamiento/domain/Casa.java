package com.camilo.agencia_arrendamiento.domain;

public class Casa extends Inmueble implements Arrendable{
    private long valorarriendo;

    public Casa(String direccion, long valorVenta, long valorArriendo) {
        super(direccion, valorVenta);
        this.valorarriendo = valorArriendo;
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
        return "Casa{" +
                "valorarriendo=" + valorarriendo +
                ", arrendado=" + arrendado +
               ", "+ super.toString();
    }
}
