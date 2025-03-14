package com.ander.aplicacioniniciativas.Models;

import io.realm.RealmObject;

public class Profesor {
    private int idProfesor;
    private String nombre;

    public Profesor(int idProfesor, String nombre) {
        this.idProfesor = idProfesor;
        this.nombre = nombre;
    }

    public Profesor() {}

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}

