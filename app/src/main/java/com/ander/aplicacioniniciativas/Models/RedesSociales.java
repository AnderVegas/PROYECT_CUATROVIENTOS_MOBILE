package com.ander.aplicacioniniciativas.Models;

import com.google.gson.annotations.SerializedName;

public class RedesSociales {

    @SerializedName(value = "id")
    private int idRed;
    @SerializedName(value = "nombre", alternate = "nombreRRSS")
    private String nombre;
    private String enlace;

    public RedesSociales(int idRed, String nombre, String enlace) {
        this.idRed = idRed;
        this.nombre = nombre;
        this.enlace = enlace;
    }

    public RedesSociales() {
    }

    public int getIdRed() {
        return idRed;
    }

    public void setIdRed(int idRed) {
        this.idRed = idRed;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }
}
