package com.ander.aplicacioniniciativas.Models.Indicadores.Indicador3;

import com.ander.aplicacioniniciativas.Models.Indicador;

import java.util.List;

public class IndicadorCiclosModulosIniciativas3 extends Indicador {

    private List<IniciativaConCiclosYModulos3> iniciativasConCiclosYModulos;

    public IndicadorCiclosModulosIniciativas3() {
    }

    public IndicadorCiclosModulosIniciativas3(int idIndicador, String descripcion, List<Float> datosGraficos, List<String> etiquetasEjeX, List<IniciativaConCiclosYModulos3> iniciativasConCiclosYModulos) {
        super(idIndicador, descripcion, datosGraficos, etiquetasEjeX);
        this.iniciativasConCiclosYModulos = iniciativasConCiclosYModulos;
    }

    public List<IniciativaConCiclosYModulos3> getIniciativasConCiclosYModulos() {
        return iniciativasConCiclosYModulos;
    }

    public void setIniciativasConCiclosYModulos(List<IniciativaConCiclosYModulos3> iniciativasConCiclosYModulos) {
        this.iniciativasConCiclosYModulos = iniciativasConCiclosYModulos;
    }
}
