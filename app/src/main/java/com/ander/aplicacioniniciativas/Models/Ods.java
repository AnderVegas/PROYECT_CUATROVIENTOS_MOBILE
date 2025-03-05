package com.ander.aplicacioniniciativas.Models;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Ods extends RealmObject {
    private int idOds;
    private String nombre;
    private RealmList<Dimension> dimension;

    public Ods(int idOds, String nombre, RealmList<Dimension> dimension) {
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

    public RealmList<Dimension> getDimension() {
        return dimension;
    }

    public void setDimension(RealmList<Dimension> dimension) {
        this.dimension = dimension;
    }
}

