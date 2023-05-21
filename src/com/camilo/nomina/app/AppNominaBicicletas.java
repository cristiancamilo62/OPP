package com.camilo.nomina.app;

import com.camilo.nomina.domain.*;
import com.camilo.nomina.excepcion.ValorInvalidoExcepcion;

public class AppNominaBicicletas {
    public static void main(String[] args) {
        Nomina nomina1 = new Nomina();
        try {
            Empleado Juan = new Directo("Juan", 4_840_000);
            nomina1.getEmpleados().add(Juan);
            Empleado Julian = new Vendedor("Julian", 2_050_000, 45_510_000);
            nomina1.getEmpleados().add(Julian);
            Empleado Johana = new Freelance("Johana", 71_000, 89);
            nomina1.getEmpleados().add(Johana);
            Empleado Carolina = new Vendedor("Carolina", 980_000, 35_989_000);
            nomina1.getEmpleados().add(Carolina);
            Empleado Gustavo = new Freelance("Gustavo", 42_500, 65);
            nomina1.getEmpleados().add(Gustavo);
            Empleado Pedro = new Promotor("pedro", 1200, 280, 62);
            nomina1.getEmpleados().add(Pedro);
            Empleado David = new Directo("David", 3_975_000);
            nomina1.getEmpleados().add(David);

            Gustavo.calcularSalario();
            System.out.println(Julian.toString());
        }
        catch (ValorInvalidoExcepcion e){
            System.out.println(e.getMessage());
        }

        //nomina1.getEmpleados().forEach(ep-> System.out.println(ep.getNombre()+" : "+ ep.calcularSalario()));
    }
}
