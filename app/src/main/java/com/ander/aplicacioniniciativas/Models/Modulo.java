package com.ander.aplicacioniniciativas.Models;

import java.util.List;

import io.realm.RealmObject;

public class Modulo {
    private int idModulo;
    private String nombre;
    private List<Curso> curso;

    public Modulo(int idModulo, String nombre, List<Curso> curso) {
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

    public List<Curso> getCurso() {
        return curso;
    }

    public void setCurso(List<Curso> curso) {
        this.curso = curso;
    }
}

