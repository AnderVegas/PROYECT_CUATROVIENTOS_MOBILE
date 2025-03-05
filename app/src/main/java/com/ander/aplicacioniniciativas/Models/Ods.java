package com.ander.aplicacioniniciativas.Models;

import java.util.List;

public class Ods {
    private int idOds;
    private String nombre;
    private List<Dimension> dimension;

    public Ods(int idOds, String nombre, List<Dimension> dimension) {
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

    public List<Dimension> getDimension() {
        return dimension;
    }

    public void setDimension(List<Dimension> dimension) {
        this.dimension = dimension;
    }
}

