package com.ander.aplicacioniniciativas.Models.Indicadores.Indicador6;

import com.ander.aplicacioniniciativas.Models.Indicador;

import java.util.List;

public class IndicadorEntidadesExternas6 extends Indicador {

    private EntidadesExternas6 entidadesExternas;

    public IndicadorEntidadesExternas6() {
    }

    public IndicadorEntidadesExternas6(int idIndicador, String descripcion, List<Float> datosGraficos, List<String> etiquetasEjeX, EntidadesExternas6 entidadesExternas6) {
        super(idIndicador, descripcion, datosGraficos, etiquetasEjeX);
        this.entidadesExternas = entidadesExternas6;
    }

    public EntidadesExternas6 getEntidadesExternas() {
        return entidadesExternas;
    }

    public void setEntidadesExternas(EntidadesExternas6 entidadesExternas6) {
        this.entidadesExternas = entidadesExternas6;
    }
}
