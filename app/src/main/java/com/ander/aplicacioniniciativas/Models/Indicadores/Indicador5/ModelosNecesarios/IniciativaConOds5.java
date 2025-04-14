package com.ander.aplicacioniniciativas.Models.Indicadores.Indicador5.ModelosNecesarios;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class IniciativaConOds5 {

    @SerializedName("id")
    private int id;

    @SerializedName("nombre_iniciativa")
    private String nombreIniciativa;

    @SerializedName("ods")
    private List<OdsConMetas5> ods;

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombreIniciativa() { return nombreIniciativa; }
    public void setNombreIniciativa(String nombreIniciativa) { this.nombreIniciativa = nombreIniciativa; }

    public List<OdsConMetas5> getOds() { return ods; }
    public void setOds(List<OdsConMetas5> ods) { this.ods = ods; }
}



