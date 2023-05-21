package com.camilo.nomina.domain;

public class Vendedor extends Directo{
    private long ventasDelMes;

    public Vendedor(String nombre, long salario, long ventasDelMes) {
        super(nombre, salario);
        this.ventasDelMes = ventasDelMes;
    }

    public long calcularComision(){
        long comision;
        if(super.getSalario() < 1_000_000) {
            comision = (long) (this.ventasDelMes * 0.045);
        }
        else{
           comision = (long) (this.ventasDelMes*0.035);
        }
        super.setSalario(super.getSalario()+comision);
        return  comision;
    }

    @Override
    public long calcularSalario() {
        return super.calcularSalario() + this.calcularComision();
    }

    @Override
    public String toString() {
        return super.toString() +
                " Tipo Vendedor {" +
                "comisiones=" + calcularComision() +
                "} ventasDelMes{" + ventasDelMes +
                '}';
    }

    public long getVentasDelMes() {
        return ventasDelMes;
    }
}
