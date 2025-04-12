package com.ander.aplicacioniniciativas.Models.Indicadores;

import com.ander.aplicacioniniciativas.Models.Indicador;

import java.util.List;

public class IndicadorCantidadIniciativas2 extends Indicador {

    private CantidadIniciativas2 cantidadIniciativas;

    public IndicadorCantidadIniciativas2() {}

    public IndicadorCantidadIniciativas2(int idIndicador, String descripcion, List<Float> datosGraficos, List<String> etiquetasEjeX, CantidadIniciativas2 cantidadIniciativas) {
        super(idIndicador, descripcion, datosGraficos, etiquetasEjeX);
        this.cantidadIniciativas = cantidadIniciativas;
    }

    public CantidadIniciativas2 getCantidadIniciativas() {
        return cantidadIniciativas;
    }

    public void setCantidadIniciativas(CantidadIniciativas2 cantidadIniciativas) {
        this.cantidadIniciativas = cantidadIniciativas;
    }
}
