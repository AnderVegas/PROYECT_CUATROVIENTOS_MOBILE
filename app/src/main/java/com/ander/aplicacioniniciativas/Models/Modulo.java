package com.ander.aplicacioniniciativas.Models;

public class Modulo {
    private int idModulo;
    private String nombre;
    private Curso curso;

    public Modulo(int idModulo, String nombre, Curso curso) {
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

