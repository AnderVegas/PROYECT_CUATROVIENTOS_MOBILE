package com.ander.aplicacioniniciativas.Models.Indicadores;

public class IniciativasPorCurso1 {

    private String nombreCurso;
    private int numIniciativas;

    public IniciativasPorCurso1() {
    }

    public IniciativasPorCurso1(String nombreCurso, int numIniciativas) {
        this.nombreCurso = nombreCurso;
        this.numIniciativas = numIniciativas;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public int getNumIniciativas() {
        return numIniciativas;
    }

    public void setNumIniciativas(int numIniciativas) {
        this.numIniciativas = numIniciativas;
    }
}
