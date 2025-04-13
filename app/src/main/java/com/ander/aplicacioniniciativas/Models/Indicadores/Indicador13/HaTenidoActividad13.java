package com.ander.aplicacioniniciativas.Models.Indicadores.Indicador13;

import com.google.gson.annotations.SerializedName;

public class HaTenidoActividad13 {

    @SerializedName(value = "tiene_actividades")
    private String tieneActividades;
    @SerializedName(value = "no_tiene_actividades")
    private String noTieneActividades;

    public HaTenidoActividad13(String tieneActividades, String noTieneActividades) {
        this.tieneActividades = tieneActividades;
        this.noTieneActividades = noTieneActividades;
    }

    public String getTieneActividades() {
        return tieneActividades;
    }

    public void setTieneActividades(String tieneActividades) {
        this.tieneActividades = tieneActividades;
    }

    public String getNoTieneActividades() {
        return noTieneActividades;
    }

    public void setNoTieneActividades(String noTieneActividades) {
        this.noTieneActividades = noTieneActividades;
    }
}
