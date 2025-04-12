package com.ander.aplicacioniniciativas.App;

import com.ander.aplicacioniniciativas.Models.Clase;
import com.ander.aplicacioniniciativas.Models.Indicadores.CantidadIniciativas2;
import com.ander.aplicacioniniciativas.Models.Indicadores.IniciativasPorCurso1;
import com.ander.aplicacioniniciativas.Models.Indicadores.TipoIniciativa8;
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

    @GET("indicadores/iniciativasPorCurso")
    Call<List<IniciativasPorCurso1>> getIniciativasPorCurso();

    @GET("indicadores/cantidadIniciativas")
    Call<CantidadIniciativas2> getCantidadIniciativas();

    @GET("indicadores/tipoIniciativa")
    Call<List<TipoIniciativa8>> getTipoIniciativas();

}
