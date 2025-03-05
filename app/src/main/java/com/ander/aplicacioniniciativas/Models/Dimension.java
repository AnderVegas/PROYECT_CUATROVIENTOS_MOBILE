package com.ander.aplicacioniniciativas.Models;

public class Dimension {
    private int idDimension;
    private String nombre;

    public Dimension(int idDimension, String nombre) {
        this.idDimension = idDimension;
        this.nombre = nombre;
    }

    public Dimension() {}

    public int getIdDimension() {
        return idDimension;
    }

    public void setIdDimension(int idDimension) {
        this.idDimension = idDimension;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
