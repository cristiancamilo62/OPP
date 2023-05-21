package com.camilo.agencia_arrendamiento.domain;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Agencia {
    private String nombre;
    private List<Inmueble> inmuebles;

    public Agencia(String nombre) {
        this.nombre = nombre;
        this.inmuebles = new ArrayList<>();
    }

    public void agregarInmueble(Inmueble inmueble){
        if(this.inmuebles.stream().
                filter(I->I.getDireccion().equals(inmueble.getDireccion())).
                findFirst().orElse(null) == null){
            this.inmuebles.add(inmueble);
            System.out.println("inmueble agregado con exito");
        }
        else{
            System.out.println("El inmueble ya existe");
        }
    }
    public boolean arrendar(Arrendable inmueble){
        if(inmueble instanceof Arrendable && ((Inmueble) inmueble).arrendado != true){
            System.out.println("inmueble arrenado con exito");
            inmueble.arrendar();
            return true;
        }
        System.out.println("el inmueble no puede ser arrendado");
        return false;
    }
    public boolean devolver(Arrendable inmueble){
        if(((Inmueble) inmueble).arrendado == true){
            inmueble.devolver();
            System.out.println("inmueble devuelto con exito");
            return false;
        }
        System.out.println("inmueble no esta arrendado");
        return false;
    }
    public boolean vender(Inmueble inmueble){
        if(inmueble instanceof Arrendable){
            if(inmueble.arrendado){
                System.out.println("inmueble vendido");
                this.inmuebles.remove(inmueble);
                return true;
            }
            else{
                System.out.println("No se puede vender por que esta arrendado");
                return false;
            }
        }
        else{
            System.out.println("inmueble vendido");
            this.inmuebles.remove(inmueble);
        }
        return true;
    }
    public List<Inmueble> getArrendablesDisponibles(){
        List<Inmueble> inmueblesDisponibles = new ArrayList<>();
        for(Inmueble I: this.inmuebles){
            if(I.arrendado == false){
               inmueblesDisponibles.add(I);
            }
        }
        return inmueblesDisponibles;
    }
    public List<Inmueble> getArrendados(){
        List<Inmueble> inmueblesArrendados = new ArrayList<>();
        for (Inmueble I: this.inmuebles){
            if(I.arrendado == true){
                inmueblesArrendados.add(I);
            }
        }
        return inmueblesArrendados;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Inmueble> getInmuebles() {
        return inmuebles;
    }
}

