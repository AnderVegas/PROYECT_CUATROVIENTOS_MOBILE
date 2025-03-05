package com.ander.aplicacioniniciativas.Models;

import java.util.List;
import java.util.ArrayList;

public class Meta {
    private int idMetas;
    private String descripcion;
    private List<Ods> ods;

    public Meta(int idMetas, String descripcion, List<Ods> ods) {
        this.idMetas = idMetas;
        this.descripcion = descripcion;
        this.ods = ods;
    }

    public Meta(int idMetas, String descripcion, Ods ods) {
        this.idMetas = idMetas;
        this.descripcion = descripcion;
        this.ods = new ArrayList<>();
        this.ods.add(ods);
    }

    public Meta() {}

    public int getIdMetas() {
        return idMetas;
    }

    public void setIdMetas(int idMetas) {
        this.idMetas = idMetas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Ods> getOds() {
        return ods;
    }

    public void setOds(List<Ods> ods) {
        this.ods = ods;
    }
}

