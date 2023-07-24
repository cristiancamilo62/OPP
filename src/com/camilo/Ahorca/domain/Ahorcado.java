package com.camilo.Ahorca.domain;

import java.sql.Array;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;


public class Ahorcado {
    Scanner datos = new Scanner(System.in);
    private static final byte INTENTOS_TOTALES = 5;
    private String palabras[] = {"hola","pendejo","luis","mejor"};
    private char[] palabrasecreta;
    private Jugador jugador;

    public String conseguirPalabra(){
       int  posPalabra = (int) (Math.random() * this.palabras.length);
       String palabraADescubrir = this.palabras[posPalabra];
       return palabraADescubrir;
    }
    public char[] guionesPalabra(String palabra){
        this.palabrasecreta = new char[palabra.length()];
        for(int n = 0; n< palabra.length() ; n++){
            this.palabrasecreta[n] = '_';
        }
        return palabrasecreta;
    }
    public void registrarJugador(){
        System.out.println("Ingrese su nombre");
        String nombre = datos.nextLine();

        System.out.println("Ingrese su id");
        int id = datos.nextInt();

        this.jugador = new Jugador(nombre,id);
    }

    public void jugar(){
        this.registrarJugador();
        System.out.println("Bienvenido sexy "+ this.jugador.getNombre());

        String palabra =(this.conseguirPalabra());
        this.guionesPalabra((palabra));
        boolean finalizarJuego = false;
        int maximoDeIntentos = 0;
        do{
            boolean letraEncontrada = false;
            System.out.println(this.palabrasecreta);
            System.out.println("ingrese una letra");
            char letra = datos.next().charAt(0);
            for (int n = 0; n<palabra.length(); n++){
                char [] palabraA = (palabra.toCharArray());
                if(palabra.charAt(n) == letra){
                    this.palabrasecreta[n] = letra;
                    letraEncontrada = true;
                }
            }
            if (!letraEncontrada){
                System.out.println("intenta de nuevo");
                maximoDeIntentos++;
                if(maximoDeIntentos >= this.INTENTOS_TOTALES){
                    finalizarJuego = true;
                    System.out.println("intentos agotados, la palabra secreta es: "+palabra);
                }

            }
            if (!verificarPalabra(Arrays.toString(palabrasecreta))){
                System.out.println("has ganado");
                finalizarJuego = true;
            }


        }while(finalizarJuego != true);



    }
    public boolean verificarPalabra(String palabra){
        boolean salida = false;
        for(int n = 0; n<palabra.length(); n++){
            if(palabra.charAt(n) == '_'){
                salida = true;
            }
        }
        return salida;
    }


}
