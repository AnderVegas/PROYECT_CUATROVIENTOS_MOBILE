package com.ander.aplicacioniniciativas.Models.Indicadores.Indicador3.ModelosNecesarios;

import com.google.gson.annotations.SerializedName;

public class Modulo3 {

    @SerializedName("id_modulo")
    private int idModulo;

    @SerializedName("nombre_modulo")
    private String nombreModulo;

    public Modulo3() {}

    public Modulo3(int idModulo, String nombreModulo) {
        this.idModulo = idModulo;
        this.nombreModulo = nombreModulo;
    }

    public int getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(int idModulo) {
        this.idModulo = idModulo;
    }

    public String getNombreModulo() {
        return nombreModulo;
    }

    public void setNombreModulo(String nombreModulo) {
        this.nombreModulo = nombreModulo;
    }
}
