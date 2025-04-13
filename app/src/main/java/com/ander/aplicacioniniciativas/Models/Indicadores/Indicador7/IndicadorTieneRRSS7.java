package com.ander.aplicacioniniciativas.Models.Indicadores.Indicador7;

import com.ander.aplicacioniniciativas.Models.Indicador;

import java.util.List;

public class IndicadorTieneRRSS7 extends Indicador {

    private List<TieneRRSS7> tieneRRSS;

    public IndicadorTieneRRSS7(int idIndicador, String descripcion, List<Float> datosGraficos, List<String> etiquetasEjeX, List<TieneRRSS7> tieneRRSS) {
        super(idIndicador, descripcion, datosGraficos, etiquetasEjeX);
        this.tieneRRSS = tieneRRSS;
    }

    public IndicadorTieneRRSS7() {}

    public List<TieneRRSS7> getTieneRRSS() {
        return tieneRRSS;
    }

    public void setTieneRRSS(List<TieneRRSS7> tieneRRSS) {
        this.tieneRRSS = tieneRRSS;
    }
}
