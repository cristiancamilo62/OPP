package com.camilo.nomina.domain;

import java.util.ArrayList;

public class Nomina {
    private ArrayList<Empleado> empleados = new ArrayList<>();

    public void calcularNomina (){
        int nomina = 0;
        for (Empleado ep: this.empleados){
            nomina += ep.calcularSalario();
        }
        System.out.println("La nomina del mes es: "+ nomina);
    }
    public void listarDirectos (){
        for (Empleado ep: this.empleados){
            if(ep instanceof Directo){
                System.out.println(ep.toString());
            }
        }
    }
    public void listarFreelancers(){
            for (Empleado ep: this.empleados){
                if(ep instanceof Freelance){
                    System.out.println(ep.toString());
                }
            }
    }
    public void listarPromotores(){
        for (Empleado ep: this.empleados){
            if(ep instanceof Promotor){
                System.out.println(ep.toString());
            }
        }
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

}
