package com.ander.aplicacioniniciativas.Models;

import io.realm.RealmObject;

public class Curso extends RealmObject {
    private int idCurso;
    private String nombre;

    public Curso(int idCurso, String nombre) {
        this.idCurso = idCurso;
        this.nombre = nombre;
    }

    public Curso() {}

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
}
