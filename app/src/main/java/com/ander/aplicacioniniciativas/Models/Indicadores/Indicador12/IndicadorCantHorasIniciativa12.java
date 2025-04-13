package com.ander.aplicacioniniciativas.Models.Indicadores.Indicador12;

import com.ander.aplicacioniniciativas.Models.Indicador;

import java.util.List;

public class IndicadorCantHorasIniciativa12 extends Indicador {

    private List<CantHorasIniciativa12> cantHorasIniciativa;

    public IndicadorCantHorasIniciativa12() {
    }

    public IndicadorCantHorasIniciativa12(int idIndicador, String descripcion, List<Float> datosGraficos, List<String> etiquetasEjeX, List<CantHorasIniciativa12> cantHorasIniciativa) {
        super(idIndicador, descripcion, datosGraficos, etiquetasEjeX);
        this.cantHorasIniciativa = cantHorasIniciativa;
    }

    public List<CantHorasIniciativa12> getCantHorasIniciativa() {
        return cantHorasIniciativa;
    }

    public void setCantHorasIniciativa(List<CantHorasIniciativa12> cantHorasIniciativa) {
        this.cantHorasIniciativa = cantHorasIniciativa;
    }
}
