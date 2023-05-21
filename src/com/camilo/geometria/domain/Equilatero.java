package com.camilo.geometria.domain;

public class Equilatero extends Triangulo {

    public Equilatero(double altura, double base) {
        super(altura, base);
    }

    @Override
    public double getArea() {
        return (this.getBase()*super.getAltura())/2;
    }

    @Override
    public double getPerimetro() {
        return 3*super.getBase();
    }
}
