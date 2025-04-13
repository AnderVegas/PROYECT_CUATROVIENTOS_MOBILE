package com.ander.aplicacioniniciativas.Activities;

import android.util.Log;

import com.ander.aplicacioniniciativas.App.CutrovientosIniciativasService;
import com.ander.aplicacioniniciativas.Models.Indicador;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador10_1.CantProfesores10_1;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador10_1.IndicadorCantProfesores10_1;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador10_2.CantidadIniciativasProfesor10_2;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador10_2.IndicadorCantidadIniciativasProfesor10_2;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador11.DiferenciaInnovadoresYNo11;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador11.IndicadorDiferenciaInnovadoresYNo11;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador12.CantHorasIniciativa12;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador12.IndicadorCantHorasIniciativa12;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador13.HaTenidoActividad13;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador13.IndicadorHaTenidoActividad13;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador2.CantidadIniciativas2;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador2.IndicadorCantidadIniciativas2;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador1.IndicadorIniciativasPorCurso1;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador6.EntidadesExternas6;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador6.IndicadorEntidadesExternas6;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador8.IndicadorTipoIniciativa8;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador1.IniciativasPorCurso1;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador8.TipoIniciativa8;

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

                    // Indicador 2
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

                                // Indicador 6
                                apiService.getEntidadesExternas().enqueue(new Callback<List<EntidadesExternas6>>() {
                                    @Override
                                    public void onResponse(Call<List<EntidadesExternas6>> call, Response<List<EntidadesExternas6>> response) {
                                        if (response.isSuccessful() && response.body() != null && !response.body().isEmpty()) {
                                            EntidadesExternas6 entidades = response.body().get(0); // solo 1 objeto

                                            List<Float> datosEntidades = new ArrayList<>();
                                            datosEntidades.add((float) entidades.getTieneEntidades());
                                            datosEntidades.add((float) entidades.getNoTieneEntidades());

                                            List<String> etiquetasEntidades = new ArrayList<>();
                                            etiquetasEntidades.add("Con entidades");
                                            etiquetasEntidades.add("Sin entidades");

                                            IndicadorEntidadesExternas6 indicador6 = new IndicadorEntidadesExternas6(
                                                    6,
                                                    "¿Las iniciativas tienen entidades externas?",
                                                    datosEntidades,
                                                    etiquetasEntidades,
                                                    entidades
                                            );

                                            indicadores.add(indicador6);

                                            // Indicador 8
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

                                                        IndicadorTipoIniciativa8 indicador8 = new IndicadorTipoIniciativa8(
                                                                8,
                                                                "Cantidad por tipo de iniciativa",
                                                                datosTipos,
                                                                etiquetasTipos,
                                                                tipos
                                                        );

                                                        indicadores.add(indicador8);

                                                        // Indicador 10.1
                                                        apiService.getCantProfesores().enqueue(new Callback<CantProfesores10_1>() {
                                                            @Override
                                                            public void onResponse(Call<CantProfesores10_1> call, Response<CantProfesores10_1> response) {
                                                                if (response.isSuccessful() && response.body() != null) {
                                                                    Log.d(TAG, "Respuesta exitosa de getCantProfesores: " + response.body().toString());

                                                                    CantProfesores10_1 profesores = response.body();  // Ahora no es una lista, es directamente un objeto

                                                                    List<Float> datosProfesores = new ArrayList<>();
                                                                    datosProfesores.add((float) profesores.getCantProfesores());

                                                                    List<String> etiquetasProfesores = new ArrayList<>();
                                                                    etiquetasProfesores.add("Total de profesores");

                                                                    IndicadorCantProfesores10_1 indicador10_1 = new IndicadorCantProfesores10_1(
                                                                            101,
                                                                            "Cantidad de profesores involucrados",
                                                                            datosProfesores,
                                                                            etiquetasProfesores,
                                                                            profesores
                                                                    );

                                                                    indicadores.add(indicador10_1);

                                                                    // Indicador 10.2
                                                                    apiService.getCantidadIniciativasProfesor().enqueue(new Callback<List<CantidadIniciativasProfesor10_2>>() {
                                                                        @Override
                                                                        public void onResponse(Call<List<CantidadIniciativasProfesor10_2>> call, Response<List<CantidadIniciativasProfesor10_2>> response) {
                                                                            if (response.isSuccessful()) {
                                                                                List<CantidadIniciativasProfesor10_2> profes = response.body();

                                                                                List<Float> datosCantIniciativas = new ArrayList<>();
                                                                                List<String> etiquetasNombreProf = new ArrayList<>();

                                                                                for (CantidadIniciativasProfesor10_2 item : profes) {
                                                                                    datosCantIniciativas.add((float) item.getCantIniciativas());
                                                                                    etiquetasNombreProf.add(item.getNombreProfesor());
                                                                                }

                                                                                IndicadorCantidadIniciativasProfesor10_2 indicador10_2 = new IndicadorCantidadIniciativasProfesor10_2(
                                                                                        102,
                                                                                        "Cantidad por tipo de iniciativa",
                                                                                        datosCantIniciativas,
                                                                                        etiquetasNombreProf,
                                                                                        profes
                                                                                );

                                                                                indicadores.add(indicador10_2);

                                                                                // Ahora vamos a añadir el Indicador 11 después del 10.1
                                                                                apiService.getDiferenciaInnovadoresYNo().enqueue(new Callback<DiferenciaInnovadoresYNo11>() {
                                                                                    @Override
                                                                                    public void onResponse(Call<DiferenciaInnovadoresYNo11> call, Response<DiferenciaInnovadoresYNo11> response) {
                                                                                        if (response.isSuccessful() && response.body() != null) {
                                                                                            DiferenciaInnovadoresYNo11 diferencia = response.body();

                                                                                            List<Float> datosDiferencia = new ArrayList<>();
                                                                                            datosDiferencia.add((float) diferencia.getCantidadInnovadoras());
                                                                                            datosDiferencia.add((float) diferencia.getCantidadNoInnovadoras());

                                                                                            List<String> etiquetasDiferencia = new ArrayList<>();
                                                                                            etiquetasDiferencia.add("Innovadoras");
                                                                                            etiquetasDiferencia.add("No innovadoras");

                                                                                            IndicadorDiferenciaInnovadoresYNo11 indicador11 = new IndicadorDiferenciaInnovadoresYNo11(
                                                                                                    11,
                                                                                                    "Diferencia entre iniciativas innovadoras y no innovadoras",
                                                                                                    datosDiferencia,
                                                                                                    etiquetasDiferencia,
                                                                                                    diferencia
                                                                                            );

                                                                                            indicadores.add(indicador11);

                                                                                            // Ahora, obtenemos el Indicador 12 (horas dedicadas a cada iniciativa)
                                                                                            apiService.getCantHorasIniciativa().enqueue(new Callback<List<CantHorasIniciativa12>>() {
                                                                                                @Override
                                                                                                public void onResponse(Call<List<CantHorasIniciativa12>> call, Response<List<CantHorasIniciativa12>> response) {
                                                                                                    if (response.isSuccessful() && response.body() != null) {
                                                                                                        List<CantHorasIniciativa12> horasIniciativas = response.body();

                                                                                                        // Listas para los gráficos (suponiendo que quieres mostrar un gráfico con los datos)
                                                                                                        List<Float> datosHoras = new ArrayList<>();
                                                                                                        List<String> etiquetasHoras = new ArrayList<>();

                                                                                                        // Procesamos las horas dedicadas y las iniciativas
                                                                                                        for (CantHorasIniciativa12 iniciativa : horasIniciativas) {
                                                                                                            datosHoras.add((float) iniciativa.getHorasDedicadas());
                                                                                                            etiquetasHoras.add(iniciativa.getNombreIniciativa());
                                                                                                        }

                                                                                                        // Crear el indicador con los datos obtenidos
                                                                                                        IndicadorCantHorasIniciativa12 indicador12 = new IndicadorCantHorasIniciativa12(
                                                                                                                12, // id del indicador (ajústalo según corresponda)
                                                                                                                "Horas dedicadas a cada iniciativa", // Descripción del indicador
                                                                                                                datosHoras, // Datos para el gráfico
                                                                                                                etiquetasHoras, // Etiquetas para el gráfico
                                                                                                                horasIniciativas // La lista completa de iniciativas
                                                                                                        );

                                                                                                        // Ahora puedes añadir el indicador a tu lista de indicadores o hacer lo que necesites
                                                                                                        indicadores.add(indicador12);

                                                                                                        // Indicador 13
                                                                                                        apiService.getHaTenidoActividad().enqueue(new Callback<HaTenidoActividad13>() {
                                                                                                            @Override
                                                                                                            public void onResponse(Call<HaTenidoActividad13> call, Response<HaTenidoActividad13> response) {
                                                                                                                if (response.isSuccessful() && response.body() != null) {
                                                                                                                    HaTenidoActividad13 actividad = response.body();

                                                                                                                    List<Float> datosActividad = new ArrayList<>();
                                                                                                                    datosActividad.add(Float.parseFloat(actividad.getTieneActividades()));
                                                                                                                    datosActividad.add(Float.parseFloat(actividad.getNoTieneActividades()));

                                                                                                                    List<String> etiquetasActividad = new ArrayList<>();
                                                                                                                    etiquetasActividad.add("Con actividades");
                                                                                                                    etiquetasActividad.add("Sin actividades");

                                                                                                                    IndicadorHaTenidoActividad13 indicador13 = new IndicadorHaTenidoActividad13(
                                                                                                                            13,
                                                                                                                            "¿Las iniciativas han tenido actividades?",
                                                                                                                            datosActividad,
                                                                                                                            etiquetasActividad,
                                                                                                                            actividad
                                                                                                                    );

                                                                                                                    indicadores.add(indicador13);

                                                                                                                    // 🔚 Finalmente, devuelve todos los indicadores ya cargados
                                                                                                                    callback.onResult(indicadores);
                                                                                                                } else {
                                                                                                                    Log.e(TAG, "Error en getHaTenidoActividad: Respuesta vacía o error en la API");
                                                                                                                    callback.onError(new Exception("Error al obtener haTenidoActividad"));
                                                                                                                }
                                                                                                            }

                                                                                                            @Override
                                                                                                            public void onFailure(Call<HaTenidoActividad13> call, Throwable t) {
                                                                                                                Log.e(TAG, "Fallo en getHaTenidoActividad", t);
                                                                                                                callback.onError(t);
                                                                                                            }
                                                                                                        });

                                                                                                    } else {
                                                                                                        Log.e(TAG, "Error en getCantHorasIniciativa: Respuesta vacía o error en la API");
                                                                                                        callback.onError(new Exception("Error al obtener cantHorasIniciativa"));
                                                                                                    }
                                                                                                }

                                                                                                @Override
                                                                                                public void onFailure(Call<List<CantHorasIniciativa12>> call, Throwable t) {
                                                                                                    Log.e(TAG, "Fallo en getCantHorasIniciativa", t);
                                                                                                    callback.onError(t);
                                                                                                }
                                                                                            });

                                                                                        } else {
                                                                                            Log.e(TAG, "Error en getDiferenciaInnovadoresYNo: Respuesta vacía o error en la API");
                                                                                            callback.onError(new Exception("Error al obtener diferenciaInnovadoresYNo"));
                                                                                        }
                                                                                    }

                                                                                    @Override
                                                                                    public void onFailure(Call<DiferenciaInnovadoresYNo11> call, Throwable t) {
                                                                                        Log.e(TAG, "Fallo en getDiferenciaInnovadoresYNo", t);
                                                                                        callback.onError(t);
                                                                                    }
                                                                                });


                                                                            } else {
                                                                                Log.e(TAG, "Error en getCantidadIniciativasProfesor: " + (response.body() == null ? "Respuesta vacía" : "Código de error: " + response.code()));
                                                                                callback.onError(new Exception("Error al obtener cantProfesores"));
                                                                            }
                                                                        }

                                                                        @Override
                                                                        public void onFailure(Call<List<CantidadIniciativasProfesor10_2>> call, Throwable t) {
                                                                            Log.e(TAG, "Fallo en getCantidadIniciativasProfesor", t);
                                                                            callback.onError(t);
                                                                        }
                                                                    });

                                                                } else {
                                                                    Log.e(TAG, "Error en getCantProfesores: " + (response.body() == null ? "Respuesta vacía" : "Código de error: " + response.code()));
                                                                    callback.onError(new Exception("Error al obtener cantProfesores"));
                                                                }
                                                            }

                                                            @Override
                                                            public void onFailure(Call<CantProfesores10_1> call, Throwable t) {
                                                                Log.e(TAG, "Fallo en getCantProfesores", t);
                                                                callback.onError(t);
                                                            }
                                                        });


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
                                            callback.onError(new Exception("Error al obtener entidadesExternas"));
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<List<EntidadesExternas6>> call, Throwable t) {
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
