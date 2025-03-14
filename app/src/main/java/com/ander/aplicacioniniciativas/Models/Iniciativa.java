package com.ander.aplicacioniniciativas.Models;

import java.util.List;

public class Iniciativa {
    private int id;
    private String tipo;
    private String horas;
    private String nombre;

    private String producto_final;
    private String fechaRegistro;

    private String fechaInicio;
    private String fechaFin;
    private boolean eliminado;
    private boolean innovador;
    private String imagen;
    private List<Meta> metas;
    private List<Profesor> profesores;
    private List<EntidadExterna> entidades_externas;
    private List<Modulo> modulos;

    public Iniciativa(int id, String tipo, String horas, String nombre, String producto_final, String fechaRegistro, String fechaInicio, String fechaFin, boolean eliminado, boolean innovador, String imagen, List<Meta> metas, List<Profesor> profesores, List<EntidadExterna> entidades_externas, List<Modulo> modulos) {
        this.id = id;
        this.tipo = tipo;
        this.horas = horas;
        this.nombre = nombre;
        this.producto_final = producto_final;
        this.fechaRegistro = fechaRegistro;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.eliminado = eliminado;
        this.innovador = innovador;
        this.imagen = imagen;
        this.metas = metas;
        this.profesores = profesores;
        this.entidades_externas = entidades_externas;
        this.modulos = modulos;
    }

    public Iniciativa(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProducto_final() {
        return producto_final;
    }

    public void setProducto_final(String producto_final) {
        this.producto_final = producto_final;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public boolean isInnovador() {
        return innovador;
    }

    public void setInnovador(boolean innovador) {
        this.innovador = innovador;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<Meta> getMetas() {
        return metas;
    }

    public void setMetas(List<Meta> metas) {
        this.metas = metas;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }

    public List<EntidadExterna> getEntidades_externas() {
        return entidades_externas;
    }

    public void setEntidades_externas(List<EntidadExterna> entidades_externas) {
        this.entidades_externas = entidades_externas;
    }

    public List<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }
}
