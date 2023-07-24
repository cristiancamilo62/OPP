package com.camilo.quiz3.domain;

import com.camilo.quiz3.Excepciones.ValidacionExcepcion;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Recurso> recursos;

    public Biblioteca() {
        this.recursos = new ArrayList<>();
    }

    public void agrearRecurso(Recurso r){
        if(this.recursos.stream().filter(re->re.getNombre().equals(r.getNombre())).findFirst().orElse(null) == null){
            recursos.add(r);
        }
        else{
            System.out.println("el recurso ya existe");
        }

    }
    public boolean prestarRecurso(Recurso r){
        this.validacion(r);
        ((Prestable) r).prestar();
        return true;
    }
    public boolean devolverRecurso(Recurso r){

        this.validacion(r);
        ((Prestable)r).devolver();
        return true;
    }
    public  boolean fotocopiarRecurso(Recurso r){
        this.validacion(r);
        if(r.isPrestado() == false){
            ((Copiable)r).fotocopiar();
            return true;
        }

        return false;

    }
    public void listarPrestados(){
        for (Recurso r:this.recursos){
            if(r.isPrestado()){
                System.out.println(r);
            }
        }

    }
    public void listarCopiasPorRecurso(){
        for(Recurso r: this.recursos){
            if(r instanceof Copiable){
                System.out.println(r.getNombre()+" se ha fotocopiado " +r.copias+" veces");
            }
        }

    }
    public void validacion(Recurso r){
        if(!(r instanceof Prestable) || r.isPrestado()){
            throw new ValidacionExcepcion("No se puedes prestar");
        }
        else if(!(r instanceof Prestable) || r.isPrestado() == false){
            throw new ValidacionExcepcion("No se puede devolver el libro");
        }
        else if(!(r instanceof  Copiable)){
            throw new ValidacionExcepcion("no se puede fotocopiar");
        }
    }
}
