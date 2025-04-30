package com.ander.aplicacioniniciativas.Models;

import java.io.Serializable;
import java.util.List;

public class Indicador implements Serializable {
    
    private int idIndicador;
    
    private String descripcion;

    private List<Float> datosGraficos;

    private List<String> etiquetasEjeX;

    public Indicador() {
    }

    public Indicador(int idIndicador, String descripcion, List<Float> datosGraficos, List<String> etiquetasEjeX) {
        this.idIndicador = idIndicador;
        this.descripcion = descripcion;
        this.datosGraficos = datosGraficos;
        this.etiquetasEjeX = etiquetasEjeX;
    }

    public Indicador(int idIndicador, String descripcion, List<Float> datosGrafico) {
        this.idIndicador = idIndicador;
        this.descripcion = descripcion;
        this.datosGraficos = datosGrafico;
    }

    public Indicador(int idIndicador, String descripcion) {
        this.idIndicador = idIndicador;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdIndicador() {
        return idIndicador;
    }

    public void setIdIndicador(int idIndicador) {
        this.idIndicador = idIndicador;
    }

    public List<Float> getDatosGrafico() {
        return datosGraficos;
    }

    public void setDatosGrafico(List<Float> datosGrafico) {
        this.datosGraficos = datosGrafico;
    }

    public List<String> getEtiquetasEjeX() {
        return etiquetasEjeX;
    }

    public void setEtiquetasEjeX(List<String> etiquetasEjeX) {
        this.etiquetasEjeX = etiquetasEjeX;
    }
}

