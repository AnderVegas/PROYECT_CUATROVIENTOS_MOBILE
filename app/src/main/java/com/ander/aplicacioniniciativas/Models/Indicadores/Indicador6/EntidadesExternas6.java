package com.ander.aplicacioniniciativas.Models.Indicadores.Indicador6;

import com.google.gson.annotations.SerializedName;

public class EntidadesExternas6 {

    @SerializedName(value = "tiene_entidades")
    private int tieneEntidades;
    @SerializedName(value = "no_tiene_entidades")
    private int noTieneEntidades;

    public EntidadesExternas6(int tieneEntidades, int noTieneEntidades) {
        this.tieneEntidades = tieneEntidades;
        this.noTieneEntidades = noTieneEntidades;
    }

    public int getTieneEntidades() {
        return tieneEntidades;
    }

    public void setTieneEntidades(int tieneEntidades) {
        this.tieneEntidades = tieneEntidades;
    }

    public int getNoTieneEntidades() {
        return noTieneEntidades;
    }

    public void setNoTieneEntidades(int noTieneEntidades) {
        this.noTieneEntidades = noTieneEntidades;
    }
}
