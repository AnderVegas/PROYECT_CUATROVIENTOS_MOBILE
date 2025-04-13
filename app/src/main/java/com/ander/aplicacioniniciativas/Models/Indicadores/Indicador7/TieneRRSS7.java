package com.ander.aplicacioniniciativas.Models.Indicadores.Indicador7;

import com.ander.aplicacioniniciativas.Models.RedesSociales;
import com.google.gson.annotations.SerializedName;

public class TieneRRSS7 {

    @SerializedName("nombre_iniciativa")
    private String nombreIniciativa;

    @SerializedName("redes_sociales")
    private RedesSociales redesSociales;

    public TieneRRSS7(String nombreIniciativa, RedesSociales redesSociales) {
        this.nombreIniciativa = nombreIniciativa;
        this.redesSociales = redesSociales;
    }

    public TieneRRSS7() {}

    public String getNombreIniciativa() {
        return nombreIniciativa;
    }

    public void setNombreIniciativa(String nombreIniciativa) {
        this.nombreIniciativa = nombreIniciativa;
    }

    public RedesSociales getRedesSociales() {
        return redesSociales;
    }

    public void setRedesSociales(RedesSociales redesSociales) {
        this.redesSociales = redesSociales;
    }
}
