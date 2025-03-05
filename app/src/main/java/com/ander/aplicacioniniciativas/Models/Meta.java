package com.ander.aplicacioniniciativas.Models;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Meta extends RealmObject {
    private int idMetas;
    private String descripcion;
    private RealmList<Ods> ods;

    public Meta(int idMetas, String descripcion, RealmList<Ods> ods) {
        this.idMetas = idMetas;
        this.descripcion = descripcion;
        this.ods = ods;
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

    public RealmList<Ods> getOds() {
        return ods;
    }

    public void setOds(RealmList<Ods> ods) {
        this.ods = ods;
    }
}

