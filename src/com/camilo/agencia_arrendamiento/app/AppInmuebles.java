package com.camilo.agencia_arrendamiento.app;

import com.camilo.agencia_arrendamiento.domain.*;

public class AppInmuebles {
    public static void main(String[] args) {
        Agencia camilo = new Agencia("Camilo");
        Inmueble apartamento = new Apartamento("san carlos",30_000_000,300_000);
        Inmueble casa = new Casa("san pedro",80_000_000,20_000);
        Inmueble lote1 = new Lote("santa ana",40_000_00);
        camilo.agregarInmueble(apartamento);
        camilo.agregarInmueble(casa);
        camilo.arrendar((Arrendable) apartamento);
        camilo.devolver((Arrendable) apartamento);
        camilo.arrendar((Arrendable) apartamento);
        camilo.vender(apartamento);
        camilo.agregarInmueble(lote1);
        camilo.arrendar((Arrendable) lote1);


    }
}
