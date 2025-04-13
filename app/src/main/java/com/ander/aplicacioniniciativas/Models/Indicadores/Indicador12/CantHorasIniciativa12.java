package com.ander.aplicacioniniciativas.Models.Indicadores.Indicador12;

import com.google.gson.annotations.SerializedName;

public class CantHorasIniciativa12 {

    @SerializedName(value = "nombre_iniciativa")
    private String nombreIniciativa;
    @SerializedName(value = "horas_dedicadas")
    private int horasDedicadas;

    public CantHorasIniciativa12(String nombreIniciativa, int horasDedicadas) {
        this.nombreIniciativa = nombreIniciativa;
        this.horasDedicadas = horasDedicadas;
    }

    public String getNombreIniciativa() {
        return nombreIniciativa;
    }

    public void setNombreIniciativa(String nombreIniciativa) {
        this.nombreIniciativa = nombreIniciativa;
    }

    public int getHorasDedicadas() {
        return horasDedicadas;
    }

    public void setHorasDedicadas(int horasDedicadas) {
        this.horasDedicadas = horasDedicadas;
    }
}
