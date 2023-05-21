package com.camilo.phone.domain;

import com.sun.security.auth.NTSid;

public class Person {
    private String name;
    private String rostro;
    private String huella;
    private String patron;
    private int code;
    private String voz;

    public Person(String name, String rostro, String huella, String patron, int code, String voz) {
        this.name = name;
        this.rostro = rostro;
        this.huella = huella;
        this.patron = patron;
        this.code = code;
        this.voz = voz;
    }

    public String getRostro() {
        return rostro;
    }

    public String getHuella() {
        return huella;
    }

    public String getPatron() {
        return patron;
    }

    public int getCode() {
        return code;
    }

    public String getVoz() {
        return voz;
    }

}
