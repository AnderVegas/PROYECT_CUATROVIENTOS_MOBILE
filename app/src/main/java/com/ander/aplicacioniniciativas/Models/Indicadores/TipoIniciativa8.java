package com.ander.aplicacioniniciativas.Models.Indicadores;

public class TipoIniciativa8 {
    private String tipo;
    private int cantidad;

    // Constructor
    public TipoIniciativa8(String tipo, int cantidad) {
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    // Getters
    public String getTipo() {
        return tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    // Setters (opcional)
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}

