package com.ander.aplicacioniniciativas.Models.Indicadores.Indicador10_2;

import com.google.gson.annotations.SerializedName;

public class CantidadIniciativasProfesor10_2 {

    @SerializedName(value = "nombre_profesor")
    private String nombreProfesor;
    @SerializedName(value = "cantDeIniciativas")
    private int cantIniciativas;

    public CantidadIniciativasProfesor10_2() {
    }

    public CantidadIniciativasProfesor10_2(String nombreProfesor, int cantIniciativas) {
        this.nombreProfesor = nombreProfesor;
        this.cantIniciativas = cantIniciativas;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public int getCantIniciativas() {
        return cantIniciativas;
    }

    public void setCantIniciativas(int cantIniciativas) {
        this.cantIniciativas = cantIniciativas;
    }
}
