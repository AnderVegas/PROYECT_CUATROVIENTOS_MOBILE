package com.ander.aplicacioniniciativas.Models.Indicadores.Indicador5;

import com.ander.aplicacioniniciativas.Models.Indicador;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador5.ModelosNecesarios.IniciativaConOds5;

import java.util.List;

public class IndicadorOdsTrabajadosYSusMetas5 extends Indicador {

    private List<IniciativaConOds5> iniciativas;

    public IndicadorOdsTrabajadosYSusMetas5() {}

    public IndicadorOdsTrabajadosYSusMetas5(int idIndicador, String descripcion, List<Float> datosGraficos, List<String> etiquetasEjeX, List<IniciativaConOds5> iniciativas) {
        super(idIndicador, descripcion, datosGraficos, etiquetasEjeX);
        this.iniciativas = iniciativas;
    }

    public List<IniciativaConOds5> getIniciativas() {
        return iniciativas;
    }

    public void setIniciativas(List<IniciativaConOds5> iniciativas) {
        this.iniciativas = iniciativas;
    }
}
