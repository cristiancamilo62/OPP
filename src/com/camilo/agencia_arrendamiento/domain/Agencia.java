package com.camilo.agencia_arrendamiento.domain;

import com.camilo.nomina.excepcion.ValorInvalidoExcepcion;

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
        this.validate(inmueble);
        if(!verificarExistencia(inmueble)){
            this.inmuebles.add(inmueble);
            System.out.println("inmueble agregado con exito");
        }
        else{
            System.out.println("El inmueble ya existe");
        }
    }
    public boolean arrendar(Arrendable inmueble){
        if(verificarExistencia((Inmueble) inmueble) && !((Inmueble) inmueble).arrendado){
            System.out.println("inmueble arrendado con exito");
            inmueble.arrendar();
            return true;
        }
        System.out.println("el inmueble no exitse, o ya esta arrendado");
        return false;
    }
    public boolean devolver(Arrendable inmueble){
        if((verificarExistencia((Inmueble) inmueble) && ((Inmueble) inmueble).arrendado == true)){
            inmueble.devolver();
            System.out.println("inmueble devuelto con exito");
            return false;
        }
        System.out.println("inmueble no esta arrendado, o ya no existe");
        return false;
    }
    public boolean vender(Inmueble inmueble){
        if(verificarExistencia(inmueble)){
            if (inmueble.arrendado) {
                System.out.println("No se puede vender por que esta arrendado");
                return false;
            }
            System.out.println("inmueble vendido con exito");
            this.inmuebles.remove(inmueble);
            return true;
        }
        System.out.println("el inmueble no existe, o ya fue vendido");
        return false;
    }
    public List<Inmueble> getArrendablesDisponibles(){
        List<Inmueble> inmueblesDisponibles = new ArrayList<>();
        for(Inmueble I: this.inmuebles){
            if(I instanceof Arrendable && I.arrendado == false){
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
    private boolean verificarExistencia(Inmueble inmueble){
        if(this.inmuebles.stream().filter(I->I.getDireccion().equals(inmueble.getDireccion())).findFirst().orElse(null) != null){
            return true;
        }
        return false;
    }
    public void validate(Inmueble inmueble){
        if(inmueble.getValorArriendo() < 0 ){
            throw new ValorInvalidoExcepcion("Ingreso de valor invalido en el campo de valor arriendo\n" +
                    "el valor debe ser mayor a $0.0");
        }
        else if(inmueble.getValorVenta() <0){
            throw new ValorInvalidoExcepcion("Ingreso de valor invalido a valor venta\n" +
                    "el valor debe ser mayor a $0.0");
        }

    }

    public String getNombre() {
        return nombre;
    }

    public List<Inmueble> getInmuebles() {
        return inmuebles;
    }

}

