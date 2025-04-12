package com.ander.aplicacioniniciativas.Activities;

import android.util.Log;

import com.ander.aplicacioniniciativas.App.CutrovientosIniciativasService;
import com.ander.aplicacioniniciativas.Models.Indicador;
import com.ander.aplicacioniniciativas.Models.Indicadores.CantidadIniciativas2;
import com.ander.aplicacioniniciativas.Models.Indicadores.IndicadorCantidadIniciativas2;
import com.ander.aplicacioniniciativas.Models.Indicadores.IndicadorIniciativasPorCurso1;
import com.ander.aplicacioniniciativas.Models.Indicadores.IndicadorTipoIniciativa8;
import com.ander.aplicacioniniciativas.Models.Indicadores.IniciativasPorCurso1;
import com.ander.aplicacioniniciativas.Models.Indicadores.TipoIniciativa8;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServiceIndicadores {

    private static final String TAG = "ServiceIndicadores";

    private CutrovientosIniciativasService apiService;

    public ServiceIndicadores(CutrovientosIniciativasService apiService) {
        this.apiService = apiService;
    }

    public interface IndicadoresCallback {
        void onResult(List<Indicador> indicadores);
        void onError(Throwable t);
    }

    public void getIndicadores(final IndicadoresCallback callback) {
        List<Indicador> indicadores = new ArrayList<>();

        apiService.getIniciativasPorCurso().enqueue(new Callback<List<IniciativasPorCurso1>>() {
            @Override
            public void onResponse(Call<List<IniciativasPorCurso1>> call, Response<List<IniciativasPorCurso1>> response) {
                if (response.isSuccessful()) {
                    List<IniciativasPorCurso1> iniciativas = response.body();

                    List<Float> datosGraficos = new ArrayList<>();
                    List<String> etiquetas = new ArrayList<>();

                    for (IniciativasPorCurso1 item : iniciativas) {
                        datosGraficos.add((float) item.getNumIniciativas());
                        etiquetas.add(item.getNombreCurso());
                    }

                    IndicadorIniciativasPorCurso1 indicador1 = new IndicadorIniciativasPorCurso1(
                            1,
                            "Iniciativas realizadas por curso académico",
                            datosGraficos,
                            etiquetas,
                            iniciativas
                    );

                    indicadores.add(indicador1);

                    // Segunda llamada
                    apiService.getCantidadIniciativas().enqueue(new Callback<CantidadIniciativas2>() {
                        @Override
                        public void onResponse(Call<CantidadIniciativas2> call, Response<CantidadIniciativas2> response) {
                            if (response.isSuccessful()) {
                                CantidadIniciativas2 cantidad = response.body();

                                List<Float> datosCantidad = new ArrayList<>();
                                datosCantidad.add((float) cantidad.getCantidad());

                                List<String> etiquetasCantidad = new ArrayList<>();
                                etiquetasCantidad.add("Total");

                                IndicadorCantidadIniciativas2 indicador2 = new IndicadorCantidadIniciativas2(
                                        2,
                                        "Cantidad total de iniciativas",
                                        datosCantidad,
                                        etiquetasCantidad,
                                        cantidad
                                );

                                indicadores.add(indicador2);

                                // Tercera llamada: tipo de iniciativas
                                apiService.getTipoIniciativas().enqueue(new Callback<List<TipoIniciativa8>>() {
                                    @Override
                                    public void onResponse(Call<List<TipoIniciativa8>> call, Response<List<TipoIniciativa8>> response) {
                                        if (response.isSuccessful()) {
                                            List<TipoIniciativa8> tipos = response.body();

                                            List<Float> datosTipos = new ArrayList<>();
                                            List<String> etiquetasTipos = new ArrayList<>();

                                            for (TipoIniciativa8 item : tipos) {
                                                datosTipos.add((float) item.getCantidad());
                                                etiquetasTipos.add(item.getTipo());
                                            }

                                            IndicadorTipoIniciativa8 indicador3 = new IndicadorTipoIniciativa8(
                                                    3,
                                                    "Cantidad por tipo de iniciativa",
                                                    datosTipos,
                                                    etiquetasTipos,
                                                    tipos
                                            );

                                            indicadores.add(indicador3);

                                            callback.onResult(indicadores); // ✅ Todo listo
                                        } else {
                                            callback.onError(new Exception("Error al obtener tipoIniciativas"));
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<List<TipoIniciativa8>> call, Throwable t) {
                                        callback.onError(t);
                                    }
                                });

                            } else {
                                callback.onError(new Exception("Error al obtener cantidadIniciativas"));
                            }
                        }

                        @Override
                        public void onFailure(Call<CantidadIniciativas2> call, Throwable t) {
                            callback.onError(t);
                        }
                    });

                } else {
                    callback.onError(new Exception("Error al obtener iniciativasPorCurso"));
                }
            }

            @Override
            public void onFailure(Call<List<IniciativasPorCurso1>> call, Throwable t) {
                callback.onError(t);
            }
        });
    }

}
