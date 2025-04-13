package com.ander.aplicacioniniciativas.App;

import com.ander.aplicacioniniciativas.Models.Clase;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador10_1.CantProfesores10_1;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador10_2.CantidadIniciativasProfesor10_2;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador11.DiferenciaInnovadoresYNo11;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador12.CantHorasIniciativa12;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador13.HaTenidoActividad13;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador2.CantidadIniciativas2;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador1.IniciativasPorCurso1;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador3.IniciativaConCiclosYModulos3;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador4.ExplicacionIniciativas4;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador6.EntidadesExternas6;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador7.TieneRRSS7;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador8.TipoIniciativa8;
import com.ander.aplicacioniniciativas.Models.Iniciativa;
import com.ander.aplicacioniniciativas.Models.Ods;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CutrovientosIniciativasService {

    @GET("iniciativas")
    Call<List<Iniciativa>> getIniciativas(@Query("eliminado") boolean eliminado);

    @GET("ods")
    Call<List<Ods>> getOds();

    @GET("clases")
    Call<List<Clase>> getCursos();

    // Indicador 1
    @GET("indicadores/iniciativasPorCurso")
    Call<List<IniciativasPorCurso1>> getIniciativasPorCurso();

    // Indicador 2
    @GET("indicadores/cantidadIniciativas")
    Call<CantidadIniciativas2> getCantidadIniciativas();

    // Indicador 3
    @GET("indicadores/ciclosYModulosConInciativas")
    Call<List<IniciativaConCiclosYModulos3>> getCiclosYModulosConInciativas();

    // Indicador 4
    @GET("indicadores/explicacionIniciativas")
    Call<List<ExplicacionIniciativas4>> getExplicacionIniciativas();

    //  Indicador 6
    @GET("indicadores/tieneEntidadesExternas")
    Call<List<EntidadesExternas6>> getEntidadesExternas();

    //  Indicador 7
    @GET("indicadores/tieneRRSS")
    Call<List<TieneRRSS7>> getTieneRRSS();

    // Indicador 8
    @GET("indicadores/tipoIniciativa")
    Call<List<TipoIniciativa8>> getTipoIniciativas();

    // Indicador 10.1
    @GET("indicadores/cantProfesores")
    Call<CantProfesores10_1> getCantProfesores();

    // Indicador 10.2
    @GET("indicadores/cantIniciativasProfesor")
    Call <List<CantidadIniciativasProfesor10_2>> getCantidadIniciativasProfesor();

    // Indicador 11
    @GET("indicadores/diferenciaInnovadoresYNo")
    Call<DiferenciaInnovadoresYNo11> getDiferenciaInnovadoresYNo();

    // Indicador 12
    @GET("indicadores/cantHorasIniciativa")
    Call<List<CantHorasIniciativa12>> getCantHorasIniciativa();

    // Indicador 13
    @GET("indicadores/haTendioActividad")
    Call<HaTenidoActividad13> getHaTenidoActividad();

}
