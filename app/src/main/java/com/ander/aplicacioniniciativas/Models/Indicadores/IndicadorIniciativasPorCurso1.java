package com.ander.aplicacioniniciativas.Models.Indicadores;

import com.ander.aplicacioniniciativas.Models.Indicador;

import java.util.List;

public class IndicadorIniciativasPorCurso1 extends Indicador {

    private List<IniciativasPorCurso1> iniciativasPorCurso;

    public IndicadorIniciativasPorCurso1() {}

    public IndicadorIniciativasPorCurso1(int idIndicador, String descripcion, List<Float> datosGraficos, List<String> etiquetasEjeX, List<IniciativasPorCurso1> iniciativasPorCurso) {
        super(idIndicador, descripcion, datosGraficos, etiquetasEjeX);
        this.iniciativasPorCurso = iniciativasPorCurso;
    }

    public List<IniciativasPorCurso1> getIniciativasPorCurso() {
        return iniciativasPorCurso;
    }

    public void setIniciativasPorCurso(List<IniciativasPorCurso1> iniciativasPorCurso) {
        this.iniciativasPorCurso = iniciativasPorCurso;
    }
}
