package com.ander.aplicacioniniciativas.Models.Indicadores.Indicador8;

import com.ander.aplicacioniniciativas.Models.Indicador;

import java.util.List;

public class IndicadorTipoIniciativa8 extends Indicador {

    private List<TipoIniciativa8> indicadorTipoIniciativa;

    public IndicadorTipoIniciativa8() {}

    public IndicadorTipoIniciativa8(int idIndicador, String descripcion, List<Float> datosGraficos, List<String> etiquetasEjeX, List<TipoIniciativa8> indicadorTipoIniciativa) {
        super(idIndicador, descripcion, datosGraficos, etiquetasEjeX);
        this.indicadorTipoIniciativa = indicadorTipoIniciativa;
    }

    public List<TipoIniciativa8> getIndicadorTipoIniciativa8() {
        return indicadorTipoIniciativa;
    }

    public void setIndicadorTipoIniciativa8(List<TipoIniciativa8> indicadorTipoIniciativa8) {
        this.indicadorTipoIniciativa = indicadorTipoIniciativa8;
    }
}
