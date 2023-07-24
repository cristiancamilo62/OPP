package com.camilo.agencia_arrendamiento.app;

import com.camilo.agencia_arrendamiento.domain.*;

public class AppInmuebles {
    public static void main(String[] args) {
        Agencia camilo = new Agencia("Camilo");
        try{
            Inmueble apartamento = new Apartamento("san carlos",30_000_000,300_000);
            Inmueble casa = new Casa("san pedro",80_000_000,20_000);
            Inmueble lote1 = new Lote("santa ana",40_000_00);
            camilo.agregarInmueble(apartamento);
            camilo.agregarInmueble(casa);
            camilo.arrendar((Arrendable) apartamento);
            camilo.agregarInmueble(lote1);
            camilo.agregarInmueble(casa);
            camilo.arrendar((Arrendable) lote1);
            System.out.println(lote1.isArrendado());
        }catch (RuntimeException exception){
            //System.out.println(exception.getMessage());
        }

       // camilo.devolver((Arrendable) apartamento);
        //camilo.vender(lote1);
        //camilo.vender(apartamento);
        //System.out.println(camilo.getArrendados());
        //System.out.println(camilo.getInmuebles());
       // System.out.println(camilo.getArrendablesDisponibles());
        //System.out.println(camilo.getArrendablesDisponibles());
        //System.out.println(camilo.getInmuebles());



    }
}
