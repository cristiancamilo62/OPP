package com.camilo.geometria.domain;

public class Cuadrado extends  FigurasGeometricas {
    private double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public double getArea() {
        return Math.pow(this.lado,2);
    }

    @Override
    public double getPerimetro() {
        return 4*this.lado;
    }
}
