package com.ander.aplicacioniniciativas.Models.Indicadores.Indicador5.ModelosNecesarios;

import com.google.gson.annotations.SerializedName;

public class Meta5 {

    @SerializedName("id_meta")
    private int idMeta;

    @SerializedName("nombre_meta")
    private String nombreMeta;

    public int getIdMeta() { return idMeta; }

    public void setIdMeta(int idMeta) { this.idMeta = idMeta; }

    public String getNombreMeta() { return nombreMeta; }

    public void setNombreMeta(String nombreMeta) { this.nombreMeta = nombreMeta; }
}

