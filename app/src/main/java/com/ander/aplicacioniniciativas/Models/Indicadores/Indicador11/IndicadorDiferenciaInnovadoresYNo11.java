package com.ander.aplicacioniniciativas.Models.Indicadores.Indicador11;

import com.ander.aplicacioniniciativas.Models.Indicador;

import java.util.List;

public class IndicadorDiferenciaInnovadoresYNo11 extends Indicador {

    private List<DiferenciaInnovadoresYNo11> diferenciaInnovadoresYNo;

    public IndicadorDiferenciaInnovadoresYNo11() {
    }

    public IndicadorDiferenciaInnovadoresYNo11(int idIndicador, String descripcion, List<Float> datosGraficos, List<String> etiquetasEjeX, List<DiferenciaInnovadoresYNo11> diferenciaInnovadoresYNo) {
        super(idIndicador, descripcion, datosGraficos, etiquetasEjeX);
        this.diferenciaInnovadoresYNo = diferenciaInnovadoresYNo;
    }

    public List<DiferenciaInnovadoresYNo11> getDiferenciaInnovadoresYNo() {
        return diferenciaInnovadoresYNo;
    }

    public void setDiferenciaInnovadoresYNo(List<DiferenciaInnovadoresYNo11> diferenciaInnovadoresYNo11) {
        this.diferenciaInnovadoresYNo = diferenciaInnovadoresYNo11;
    }
}
