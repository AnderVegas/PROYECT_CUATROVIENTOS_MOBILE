package com.ander.aplicacioniniciativas.Models.Indicadores.Indicador11;

import com.google.gson.annotations.SerializedName;

public class DiferenciaInnovadoresYNo11 {

    @SerializedName(value = "cantidad_innovadoras")
    private int cantidadInnovadoras;
    @SerializedName(value = "cantidad_no_innovadoras")
    private int cantidadNoInnovadoras;

    public DiferenciaInnovadoresYNo11(int cantidadInnovadoras, int cantidadNoInnovadoras) {
        this.cantidadInnovadoras = cantidadInnovadoras;
        this.cantidadNoInnovadoras = cantidadNoInnovadoras;
    }

    public int getCantidadInnovadoras() {
        return cantidadInnovadoras;
    }

    public void setCantidadInnovadoras(int cantidadInnovadoras) {
        this.cantidadInnovadoras = cantidadInnovadoras;
    }

    public int getCantidadNoInnovadoras() {
        return cantidadNoInnovadoras;
    }

    public void setCantidadNoInnovadoras(int cantidadNoInnovadoras) {
        this.cantidadNoInnovadoras = cantidadNoInnovadoras;
    }
}
