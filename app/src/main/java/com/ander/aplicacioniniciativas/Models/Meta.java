package com.ander.aplicacioniniciativas.Models;

import com.google.gson.annotations.SerializedName;

public class Meta {
    private int idMeta;
    private String descripcion;

    @SerializedName(value = "idOds", alternate = {"ods"})
    private Ods ods;

    public Meta(int idMetas, String descripcion, Ods ods) {
        this.idMeta = idMetas;
        this.descripcion = descripcion;
        this.ods = ods;
    }

    public Meta() {}

    public int getIdMeta() {
        return idMeta;
    }

    public void setIdMeta(int idMeta) {
        this.idMeta = idMeta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Ods getOds() {
        return ods;
    }

    public void setOds(Ods ods) {
        this.ods = ods;
    }
}

