package com.camilo.geometria.domain;

public  class Triangulo extends FigurasGeometricas{
    private double altura;
    private double base;

    public Triangulo(double altura, double base) {
        this.altura = altura;
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }
    public double getBase() {
        return base;
    }
}
