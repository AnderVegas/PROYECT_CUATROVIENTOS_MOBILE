package com.ander.aplicacioniniciativas.Models.Indicadores.Indicador5.ModelosNecesarios;

import com.google.gson.annotations.SerializedName;
import com.ander.aplicacioniniciativas.Models.Ods;

import java.util.List;

public class OdsConMetas5 {

    @SerializedName("id_ods")
    private int idOds;

    @SerializedName("nombre_ods")
    private String nombreOds;

    @SerializedName("metas")
    private List<Meta5> metas;

    public int getIdOds() { return idOds; }

    public void setIdOds(int idOds) { this.idOds = idOds; }

    public String getNombreOds() { return nombreOds; }

    public void setNombreOds(String nombreOds) { this.nombreOds = nombreOds; }

    public List<Meta5> getMetas() { return metas; }
    public void setMetas(List<Meta5> metas) { this.metas = metas; }
}
