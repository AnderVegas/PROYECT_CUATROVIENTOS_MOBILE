package com.ander.aplicacioniniciativas.Models;

import com.google.gson.annotations.SerializedName;

public class Clase {
    @SerializedName(value = "id", alternate = {"idClase"})
    private int idCurso;

    @SerializedName("nombre")
    private String nombre;

    public Clase(int idCurso, String nombre) {
        this.idCurso = idCurso;
        this.nombre = nombre;
    }

    public Clase() {}

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public String toString() {
        return nombre;
    }
}
