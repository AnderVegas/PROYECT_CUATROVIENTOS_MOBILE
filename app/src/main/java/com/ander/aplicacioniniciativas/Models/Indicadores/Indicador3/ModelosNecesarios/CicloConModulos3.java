package com.ander.aplicacioniniciativas.Models.Indicadores.Indicador3.ModelosNecesarios;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CicloConModulos3 {

    @SerializedName("id_ciclo")
    private int idCiclo;

    @SerializedName("nombre_ciclo")
    private String nombreCiclo;

    @SerializedName("modulos")
    private List<Modulo3> modulos;

    public CicloConModulos3() {}

    public CicloConModulos3(int idCiclo, String nombreCiclo, List<Modulo3> modulos) {
        this.idCiclo = idCiclo;
        this.nombreCiclo = nombreCiclo;
        this.modulos = modulos;
    }

    public int getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(int idCiclo) {
        this.idCiclo = idCiclo;
    }

    public String getNombreCiclo() {
        return nombreCiclo;
    }

    public void setNombreCiclo(String nombreCiclo) {
        this.nombreCiclo = nombreCiclo;
    }

    public List<Modulo3> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulo3> modulos) {
        this.modulos = modulos;
    }
}
