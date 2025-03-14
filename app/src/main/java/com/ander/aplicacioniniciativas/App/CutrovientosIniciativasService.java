package com.ander.aplicacioniniciativas.App;

import com.ander.aplicacioniniciativas.Models.Curso;
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

    @GET("cursos")
    Call<List<Curso>> getCursos();
}
