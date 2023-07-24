package com.camilo.quiz3.domain;

import java.util.Date;

public class Noticias extends Recurso implements Copiable{
    private Date fecha;
    public Noticias(String nombre,Date fecha) {
        super(nombre);
        this.fecha = fecha;
    }

    @Override
    public void fotocopiar() {
        this.copias++;
    }
}
