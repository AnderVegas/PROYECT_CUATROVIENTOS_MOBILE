package com.ander.aplicacioniniciativas.Models.Indicadores.Indicador3;

import com.ander.aplicacioniniciativas.Models.Indicador;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador3.ModelosNecesarios.IniciativaConCiclos3;

import java.util.List;

public class IndicadorCiclosModulosIniciativas3 extends Indicador {

    private List<IniciativaConCiclos3> iniciativaConCiclos;

    public IndicadorCiclosModulosIniciativas3() {
    }

    public IndicadorCiclosModulosIniciativas3(int idIndicador, String descripcion, List<Float> datosGraficos, List<String> etiquetasEjeX, List<IniciativaConCiclos3> iniciativaConCiclos) {
        super(idIndicador, descripcion, datosGraficos, etiquetasEjeX);
        this.iniciativaConCiclos = iniciativaConCiclos;
    }

    public List<IniciativaConCiclos3> getIniciativaConCiclos() {
        return iniciativaConCiclos;
    }

    public void setIniciativaConCiclos(List<IniciativaConCiclos3> iniciativaConCiclos) {
        this.iniciativaConCiclos = iniciativaConCiclos;
    }
}
