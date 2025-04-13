package com.ander.aplicacioniniciativas.Models.Indicadores.Indicador13;

import com.ander.aplicacioniniciativas.Models.Indicador;

import java.util.List;

public class IndicadorHaTenidoActividad13 extends Indicador {

    private HaTenidoActividad13 haTenidoActividad;

    public IndicadorHaTenidoActividad13() {
    }

    public IndicadorHaTenidoActividad13(int idIndicador, String descripcion, List<Float> datosGraficos, List<String> etiquetasEjeX, HaTenidoActividad13 haTenidoActividad13) {
        super(idIndicador, descripcion, datosGraficos, etiquetasEjeX);
        this.haTenidoActividad = haTenidoActividad13;
    }

    public HaTenidoActividad13 getHaTenidoActividad() {
        return haTenidoActividad;
    }

    public void setHaTenidoActividad(HaTenidoActividad13 haTenidoActividad13) {
        this.haTenidoActividad = haTenidoActividad13;
    }
}
