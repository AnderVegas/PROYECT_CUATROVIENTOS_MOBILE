package com.ander.aplicacioniniciativas.Models;

public class Indicador {
    
    private int idIndicador;
    
    private String descripcion;

    public Indicador() {
    }

    public Indicador(int idIndicador, String descripcion) {
        this.idIndicador = idIndicador;
        this.descripcion = descripcion;
    }

    public int getId() {
        return idIndicador;
    }

    public void setId(int idIndicador) {
        this.idIndicador = idIndicador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
