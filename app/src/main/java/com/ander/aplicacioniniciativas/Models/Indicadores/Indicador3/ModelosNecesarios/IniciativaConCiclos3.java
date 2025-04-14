package com.ander.aplicacioniniciativas.Models.Indicadores.Indicador3.ModelosNecesarios;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class IniciativaConCiclos3 {

    @SerializedName("id")
    private int idIniciativa;

    @SerializedName("nombre_iniciativa")
    private String nombreIniciativa;

    @SerializedName("ciclos")
    private List<CicloConModulos3> ciclos;

    public IniciativaConCiclos3() {}

    public IniciativaConCiclos3(int idIniciativa, String nombreIniciativa, List<CicloConModulos3> ciclos) {
        this.idIniciativa = idIniciativa;
        this.nombreIniciativa = nombreIniciativa;
        this.ciclos = ciclos;
    }

    public int getIdIniciativa() {
        return idIniciativa;
    }

    public void setIdIniciativa(int idIniciativa) {
        this.idIniciativa = idIniciativa;
    }

    public String getNombreIniciativa() {
        return nombreIniciativa;
    }

    public void setNombreIniciativa(String nombreIniciativa) {
        this.nombreIniciativa = nombreIniciativa;
    }

    public List<CicloConModulos3> getCiclos() {
        return ciclos;
    }

    public void setCiclos(List<CicloConModulos3> ciclos) {
        this.ciclos = ciclos;
    }
}
