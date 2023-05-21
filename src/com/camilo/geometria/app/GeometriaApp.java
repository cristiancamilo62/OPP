package com.camilo.geometria.app;

import com.camilo.geometria.domain.Cuadrado;
import com.camilo.geometria.domain.Equilatero;
import com.camilo.geometria.domain.FigurasGeometricas;

public class GeometriaApp {
    public static void main(String[] args) {
        FigurasGeometricas cuadrado = new FigurasGeometricas();
        cuadrado = new Cuadrado(2);
        System.out.println(cuadrado.getArea()+"\n");

        cuadrado = new Equilatero(2,2
        );
        System.out.println(cuadrado.getPerimetro());

    }
}
