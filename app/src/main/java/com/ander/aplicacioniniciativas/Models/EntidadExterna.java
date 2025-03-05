package com.ander.aplicacioniniciativas.Models;

import io.realm.RealmObject;

public class EntidadExterna extends RealmObject {
    private int idEntidadExterna;
    private String nombre;

    public EntidadExterna(int idEntidadeExterna, String nombre) {
        this.idEntidadExterna = idEntidadExterna;
        this.nombre = nombre;
    }

    public EntidadExterna() {}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdEntidadExterna() {
        return idEntidadExterna;
    }

    public void setIdEntidadExterna(int idEntidadExterna) {
        this.idEntidadExterna = idEntidadExterna;
    }
}

