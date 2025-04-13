package com.ander.aplicacioniniciativas.Models.Indicadores.Indicador10_1;

import com.google.gson.annotations.SerializedName;

public class CantProfesores10_1 {

    @SerializedName(value = "cantidad")
    private int cantProfesores;

    public CantProfesores10_1(int cantProfesores) {
        this.cantProfesores = cantProfesores;
    }

    public int getCantProfesores() {
        return cantProfesores;
    }

    public void setCantProfesores(int cantProfesores) {
        this.cantProfesores = cantProfesores;
    }
}
