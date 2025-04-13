package com.ander.aplicacioniniciativas.Models.Indicadores.Indicador10_1;

import com.ander.aplicacioniniciativas.Models.Indicador;

import java.util.List;

public class IndicadorCantProfesores10_1 extends Indicador {

    private CantProfesores10_1 cantProfesores;

    public IndicadorCantProfesores10_1() {
    }

    public IndicadorCantProfesores10_1(int idIndicador, String descripcion, List<Float> datosGraficos, List<String> etiquetasEjeX, CantProfesores10_1 cantProfesores101) {
        super(idIndicador, descripcion, datosGraficos, etiquetasEjeX);
        this.cantProfesores = cantProfesores101;
    }

    public CantProfesores10_1 getCantProfesores() {
        return cantProfesores;
    }

    public void setCantProfesores(CantProfesores10_1 cantProfesores101) {
        this.cantProfesores = cantProfesores101;
    }
}
