package com.camilo.geometria.domain;

public class Isoceles extends Triangulo{
    private double ladoCongruente;

    public Isoceles(double altura, double base) {
        super(altura, base);
    }


    @Override
    public double getArea() {
        return (this.getBase()*this.getAltura())/2;
    }

    @Override
    public double getPerimetro() {
        return 0;
    }

}
