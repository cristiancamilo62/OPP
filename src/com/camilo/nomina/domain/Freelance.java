package com.camilo.nomina.domain;

import com.camilo.nomina.excepcion.ValorInvalidoExcepcion;

public class Freelance extends Empleado{
    private long valorHora;
    private int horasTrabajadas;

    public Freelance(String nombre, long valorHora, int horasTrabajadas) {
        super(nombre);
        this.valorHora = valorHora;
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public long calcularSalario() {
        if(this.horasTrabajadas < 0){
            throw new ValorInvalidoExcepcion("no seas suavecito");
        }
        long saldo = this.horasTrabajadas*this.valorHora;
        return saldo;
    }

    @Override
    public String toString() {

        return super.toString()+
                " Empleado freelance{" +
                "valorHora=" + valorHora +
                "} horasTrabajadas{" + horasTrabajadas +
                '}';
    }

    public long getValorHora() {
        return valorHora;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }
}
