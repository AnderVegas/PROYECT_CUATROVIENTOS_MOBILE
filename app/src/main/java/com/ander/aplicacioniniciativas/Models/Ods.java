package com.ander.aplicacioniniciativas.Models;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Ods {
    private int idOds;
    private String nombre;
    private Dimension dimension;

    public Ods(int idOds, String nombre, Dimension dimension) {
        this.idOds = idOds;
        this.nombre = nombre;
        this.dimension = dimension;
    }
    public Ods() {}

    public int getIdOds() {
        return idOds;
    }

    public void setIdOds(int idOds) {
        this.idOds = idOds;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }
}

