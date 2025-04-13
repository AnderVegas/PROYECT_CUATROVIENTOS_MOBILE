package com.ander.aplicacioniniciativas.Models.Indicadores.Indicador4;

import com.ander.aplicacioniniciativas.Models.Indicador;

import java.util.List;

public class IndicadorExplicacionIniciativas4 extends Indicador {

    private List<ExplicacionIniciativas4> explicacionIniciativas;

    public IndicadorExplicacionIniciativas4() {
    }

    public IndicadorExplicacionIniciativas4(int idIndicador, String descripcion, List<Float> datosGraficos, List<String> etiquetasEjeX, List<ExplicacionIniciativas4> explicacionIniciativas) {
        super(idIndicador, descripcion, datosGraficos, etiquetasEjeX);
        this.explicacionIniciativas = explicacionIniciativas;
    }

    public List<ExplicacionIniciativas4> getExplicacionIniciativas() {
        return explicacionIniciativas;
    }

    public void setExplicacionIniciativas(List<ExplicacionIniciativas4> explicacionIniciativas) {
        this.explicacionIniciativas = explicacionIniciativas;
    }
}
