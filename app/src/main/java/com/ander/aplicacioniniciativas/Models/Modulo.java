package com.ander.aplicacioniniciativas.Models;

import com.google.gson.annotations.SerializedName;

public class Modulo {
    @SerializedName(value = "id", alternate = {"idModulo"})
    private int idModulo;
    @SerializedName("clase")
    private Clase clase;
    @SerializedName("nombre")
    private String nombre;

    public Modulo(int idModulo, Clase clase, String nombre) {
        this.idModulo = idModulo;
        this.nombre = nombre;
        this.clase = clase;
    }

    public Modulo() {}

    public int getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(int idModulo) {
        this.idModulo = idModulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Clase getCurso() {
        return clase;
    }

    public void setCurso(Clase clase) {
        this.clase = clase;
    }
}

