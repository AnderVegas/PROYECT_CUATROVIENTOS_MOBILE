package com.ander.aplicacioniniciativas.Models;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class Iniciativa extends RealmObject {
    @PrimaryKey
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
    private int imagen;
    private RealmList<Meta> metas;
    private RealmList<Profesor> profesores;
    private RealmList<EntidadExterna> entidades_externas;
    private RealmList<Modulo> modulos;

    public Iniciativa(int id, String tipo, String horas, String nombre, String producto_final, String fechaRegistro, String fechaInicio, String fechaFin, boolean eliminado, boolean innovador, int imagen, RealmList<Meta> metas, RealmList<Profesor> profesores, RealmList<EntidadExterna> entidades_externas, RealmList<Modulo> modulos) {
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

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public RealmList<Meta> getMetas() {
        return metas;
    }

    public void setMetas(RealmList<Meta> metas) {
        this.metas = metas;
    }

    public RealmList<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(RealmList<Profesor> profesores) {
        this.profesores = profesores;
    }

    public RealmList<EntidadExterna> getEntidades_externas() {
        return entidades_externas;
    }

    public void setEntidades_externas(RealmList<EntidadExterna> entidades_externas) {
        this.entidades_externas = entidades_externas;
    }

    public RealmList<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(RealmList<Modulo> modulos) {
        this.modulos = modulos;
    }
}
