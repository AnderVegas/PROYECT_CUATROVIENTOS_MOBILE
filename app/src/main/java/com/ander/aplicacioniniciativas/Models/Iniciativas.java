package com.ander.aplicacioniniciativas.Models;

public class Iniciativas {
    private int id;
    private String accion;
    private String horas;
    private String nombre;
    private String productoFinal;
    private String fechaInicio;
    private String fechaFin;
    private String ods;
    private String curso;
    private boolean eliminado;
    private String imagen;
    private String imagenUrl; // Nueva propiedad

    // Constructor que recibe todos los parámetros necesarios
    public Iniciativas(int id, String accion, String horas, String nombre,
                       String productoFinal, String fechaInicio, String fechaFin,
                       String ods, String curso, boolean eliminado,
                       String imagen, String imagenUrl) {
        this.id = id;
        this.accion = accion;
        this.horas = horas;
        this.nombre = nombre;
        this.productoFinal = productoFinal;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.ods = ods;
        this.curso = curso;
        this.eliminado = eliminado;
        this.imagen = imagen;
        this.imagenUrl = imagenUrl; // Asignar imagenUrl
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
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

    public String getProductoFinal() {
        return productoFinal;
    }

    public void setProductoFinal(String productoFinal) {
        this.productoFinal = productoFinal;
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

    public String getOds() {
        return ods;
    }

    public void setOds(String ods) {
        this.ods = ods;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }
}

