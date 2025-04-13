package com.ander.aplicacioniniciativas.Models.Indicadores.Indicador3;

import java.util.List;

public class IniciativaConCiclosYModulos3 {

    private int id;
    private String nombre_iniciativa;
    private List<ClaseConModulos> ciclos;

    public IniciativaConCiclosYModulos3(int id, String nombre_iniciativa, List<ClaseConModulos> ciclos) {
        this.id = id;
        this.nombre_iniciativa = nombre_iniciativa;
        this.ciclos = ciclos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_iniciativa() {
        return nombre_iniciativa;
    }

    public void setNombre_iniciativa(String nombre_iniciativa) {
        this.nombre_iniciativa = nombre_iniciativa;
    }

    public List<ClaseConModulos> getCiclos() {
        return ciclos;
    }

    public void setCiclos(List<ClaseConModulos> ciclos) {
        this.ciclos = ciclos;
    }
}
