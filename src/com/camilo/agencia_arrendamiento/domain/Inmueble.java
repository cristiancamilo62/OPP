package com.camilo.agencia_arrendamiento.domain;

public abstract class Inmueble {
    private String direccion;
    private long valorVenta;
    private long valorArriendo;
    protected boolean arrendado;

    public Inmueble(String direccion, long valorVenta) {
        this.direccion = direccion;
        this.valorVenta = valorVenta;
    }

    public String getDireccion() {
        return direccion;
    }

    public long getValorVenta() {
        return valorVenta;
    }

    public long getValorArriendo() {
        return valorArriendo;
    }

    public  boolean isArrendado() {
        return arrendado;
    }

    public void setValorVenta(long valorVenta) {
        this.valorVenta = valorVenta;
    }

    public void setValorArriendo(long valorArriendo) {
        this.valorArriendo = valorArriendo;
    }

    @Override
    public String toString() {
        return "direccion='" + direccion + '\'' +
                ", valorVenta=" + valorVenta +
                '}';
    }
}
