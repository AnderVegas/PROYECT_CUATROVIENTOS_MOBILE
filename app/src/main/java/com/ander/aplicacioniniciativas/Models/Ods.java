package com.ander.aplicacioniniciativas.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Ods implements Serializable {
    @SerializedName(value = "id", alternate = {"idOds"})
    private int idOds;
    private String nombre;
    private String dimension;

    public Ods(int idOds, String nombre, String dimension) {
        this.idOds = idOds;
        this.nombre = nombre;
        this.dimension = dimension;
    }
    public Ods() {}

    public Ods(int idOds, String nombre){
        this.idOds = idOds;
        this.nombre = nombre;
    }

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

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    @Override
    public String toString() {
        return nombre; // Esto hará que el Spinner muestre el nombre del ODS
    }

}

