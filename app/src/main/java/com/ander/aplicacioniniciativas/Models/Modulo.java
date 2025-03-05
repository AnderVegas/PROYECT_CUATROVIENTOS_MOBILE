package com.ander.aplicacioniniciativas.Models;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Modulo extends RealmObject {
    private int idModulo;
    private String nombre;
    private RealmList<Curso> curso;

    public Modulo(int idModulo, String nombre, RealmList<Curso> curso) {
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

    public RealmList<Curso> getCurso() {
        return curso;
    }

    public void setCurso(RealmList<Curso> curso) {
        this.curso = curso;
    }
}

