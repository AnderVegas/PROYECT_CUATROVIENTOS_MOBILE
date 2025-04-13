package com.ander.aplicacioniniciativas.Models.Indicadores.Indicador8;

public class TipoIniciativa8 {
    private String tipo;
    private int cantidad;

    public TipoIniciativa8(String tipo, int cantidad) {
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}

