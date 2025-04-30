package com.ander.aplicacioniniciativas.Models.Indicadores.Indicador4;

import com.google.gson.annotations.SerializedName;

public class ExplicacionIniciativas4 {

    @SerializedName(value = "nombre")
    private String nombre;
    @SerializedName(value = "explicacion")
    private String explicacion;

    public ExplicacionIniciativas4(String nombre, String explicacion) {
        this.nombre = nombre;
        this.explicacion = explicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getExplicacion() {
        return explicacion;
    }

    public void setExplicacion(String explicacion) {
        this.explicacion = explicacion;
    }
}
