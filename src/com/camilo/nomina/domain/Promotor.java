package com.camilo.nomina.domain;

public class Promotor extends Empleado{
    private int reportesRepartidos;
    private long valorVolante;
    private int comprasVolante;

    public Promotor(String nombre, int reportesRepartidos, long valorVolante, int comprasVolante) {
        super(nombre);
        this.reportesRepartidos = reportesRepartidos;
        this.valorVolante = valorVolante;
        this.comprasVolante = comprasVolante;
    }
    @Override
    public long calcularSalario() {
        return this.reportesRepartidos*this.valorVolante + this.comprasVolante*15_000;
    }
    @Override
    public String toString() {
        return super.toString()+
                " Empleado Promotor{" +
                "reportesRepartidos=" + reportesRepartidos +
                "} valorVolante{" + valorVolante +
                "} comprasVolante{" + comprasVolante +
                '}';
    }

    public int getReportesRepartidos() {
        return reportesRepartidos;
    }

    public long getValorVolante() {
        return valorVolante;
    }

    public int getComprasVolante() {
        return comprasVolante;
    }

}
