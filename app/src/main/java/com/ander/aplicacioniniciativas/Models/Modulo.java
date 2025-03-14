package com.ander.aplicacioniniciativas.Models;

import com.google.gson.annotations.SerializedName;

public class Modulo {
    @SerializedName(value = "id", alternate = {"idModulo"})
    private int idModulo;
    @SerializedName("clase")
    private Curso curso;
    @SerializedName("nombre")
    private String nombre;

    public Modulo(int idModulo, Curso curso, String nombre) {
        this.idModulo = idModulo;
        this.nombre = nombre;
        this.curso = curso;
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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}

