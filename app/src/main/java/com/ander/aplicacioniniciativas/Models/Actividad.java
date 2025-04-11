package com.ander.aplicacioniniciativas.Models;

import com.google.gson.annotations.SerializedName;

public class Actividad {

    @SerializedName(value = "id")
    private int idActividad;

    private String nombre;

    private int imagen;

    public Actividad() {
    }

    public Actividad(int idActividad, String nombre) {
        this.idActividad = idActividad;
        this.nombre = nombre;
    }

    public Actividad(int idActividad, String nombre, int imagen) {
        this.idActividad = idActividad;
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
