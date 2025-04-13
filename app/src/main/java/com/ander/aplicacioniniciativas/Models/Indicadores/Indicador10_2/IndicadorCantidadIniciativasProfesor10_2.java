package com.ander.aplicacioniniciativas.Models.Indicadores.Indicador10_2;

import com.ander.aplicacioniniciativas.Models.Indicador;

import java.util.List;

public class IndicadorCantidadIniciativasProfesor10_2 extends Indicador {

    private List<CantidadIniciativasProfesor10_2> cantidadIniciativasProfesor;

    public IndicadorCantidadIniciativasProfesor10_2() {
    }

    public IndicadorCantidadIniciativasProfesor10_2(int idIndicador, String descripcion, List<Float> datosGraficos, List<String> etiquetasEjeX, List<CantidadIniciativasProfesor10_2> cantidadIniciativasProfesor) {
        super(idIndicador, descripcion, datosGraficos, etiquetasEjeX);
        this.cantidadIniciativasProfesor = cantidadIniciativasProfesor;
    }

    public List<CantidadIniciativasProfesor10_2> getCantidadIniciativasProfesor() {
        return cantidadIniciativasProfesor;
    }

    public void setCantidadIniciativasProfesor(List<CantidadIniciativasProfesor10_2> cantidadIniciativasProfesor) {
        this.cantidadIniciativasProfesor = cantidadIniciativasProfesor;
    }
}
