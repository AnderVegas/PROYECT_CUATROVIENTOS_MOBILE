package com.ander.aplicacioniniciativas.Models.Indicadores.Indicador3;

import com.ander.aplicacioniniciativas.Models.Modulo;

import java.util.List;

public class ClaseConModulos {
    private int id_ciclo;
    private String nombre_ciclo;
    private List<Modulo> modulos;

    public ClaseConModulos() {}

    public ClaseConModulos(int id_ciclo, String nombre_ciclo, List<Modulo> modulos) {
        this.id_ciclo = id_ciclo;
        this.nombre_ciclo = nombre_ciclo;
        this.modulos = modulos;
    }

    public int getId_ciclo() {
        return id_ciclo;
    }

    public String getNombre_ciclo() {
        return nombre_ciclo;
    }

    public List<Modulo> getModulos() {
        return modulos;
    }

    public void setId_ciclo(int id_ciclo) {
        this.id_ciclo = id_ciclo;
    }

    public void setNombre_ciclo(String nombre_ciclo) {
        this.nombre_ciclo = nombre_ciclo;
    }

    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }
}
