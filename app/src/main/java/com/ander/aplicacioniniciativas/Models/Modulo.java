package com.ander.aplicacioniniciativas.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Modulo implements Serializable {
    @SerializedName(value = "id", alternate = {"idModulo"})
    private int idModulo;
    @SerializedName("clases")
    private List<Clase> clases;
    @SerializedName("nombre")
    private String nombre;

    public Modulo(int idModulo, List<Clase> clases, String nombre) {
        this.idModulo = idModulo;
        this.nombre = nombre;
        this.clases = clases;
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

    public List<Clase> getCurso() {
        return clases;
    }

    public void setCurso(List<Clase> clases) {
        this.clases = clases;
    }

}

