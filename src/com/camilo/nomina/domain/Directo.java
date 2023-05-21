package com.camilo.nomina.domain;

public class Directo extends Empleado {
    private long salario;

    public Directo (String nombre, long salario) {
        super(nombre);
        this.salario = salario;
    }

    public long calcularSalud(){
        return (long) (this.salario * 0.05);
    }

    public long calcularPension(){
        return (long) (this.salario * 0.065);
    }

    public long clacularAporte(){
        return calcularPension()+calcularSalud();
    }

    @Override
    public long calcularSalario() {
        return this.salario - this.clacularAporte();
    }
    @Override
    public String toString() {
        return super.toString()+
                " Empleado directo{" +
                "salario=" + salario +
                '}';
    }

    public long getSalario() {

        return salario;
    }

    public void setSalario(long salario) {

        this.salario = salario;
    }
}
