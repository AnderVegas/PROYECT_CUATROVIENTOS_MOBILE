package com.ander.aplicacioniniciativas.Models.Indicadores.Indicador13;

import com.ander.aplicacioniniciativas.Models.Indicador;

import java.util.List;

public class IndicadorHaTenidoActividad13 extends Indicador {

    private List<HaTenidoActividad13> haTenidoActividad;

    public IndicadorHaTenidoActividad13() {
    }

    public IndicadorHaTenidoActividad13(int idIndicador, String descripcion, List<Float> datosGraficos, List<String> etiquetasEjeX, List<HaTenidoActividad13> haTenidoActividad) {
        super(idIndicador, descripcion, datosGraficos, etiquetasEjeX);
        this.haTenidoActividad = haTenidoActividad;
    }

    public List<HaTenidoActividad13> getHaTenidoActividad() {
        return haTenidoActividad;
    }

    public void setHaTenidoActividad(List<HaTenidoActividad13> haTenidoActividad) {
        this.haTenidoActividad = haTenidoActividad;
    }
}
