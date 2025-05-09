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
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador3.IndicadorCiclosModulosIniciativas3;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador3.ModelosNecesarios.IniciativaConCiclos3;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador4.ExplicacionIniciativas4;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador4.IndicadorExplicacionIniciativas4;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador5.IndicadorOdsTrabajadosYSusMetas5;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador5.ModelosNecesarios.IniciativaConOds5;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador5.ModelosNecesarios.Meta5;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador5.ModelosNecesarios.OdsConMetas5;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador1.IniciativasPorCurso1;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador6.EntidadesExternas6;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador6.IndicadorEntidadesExternas6;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador7.IndicadorTieneRRSS7;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador7.TieneRRSS7;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador8.IndicadorTipoIniciativa8;
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

                                // Indicador 3
                                apiService.getCiclosYModulosConInciativas().enqueue(new Callback<List<IniciativaConCiclos3>>() {
                                    @Override
                                    public void onResponse(Call<List<IniciativaConCiclos3>> call, Response<List<IniciativaConCiclos3>> response) {
                                        if (response.isSuccessful() && response.body() != null) {
                                            List<IniciativaConCiclos3> iniciativas = response.body();

                                            List<Float> datosGraficos = new ArrayList<>();
                                            List<String> etiquetas = new ArrayList<>();

                                            for (IniciativaConCiclos3 iniciativa : iniciativas) {
                                                etiquetas.add(iniciativa.getNombreIniciativa());
                                                datosGraficos.add(1f);
                                            }

                                            IndicadorCiclosModulosIniciativas3 indicador3 = new IndicadorCiclosModulosIniciativas3(
                                                    3,
                                                    "Ciclos y módulos trabajados por iniciativa",
                                                    datosGraficos,
                                                    etiquetas,
                                                    iniciativas
                                            );

                                            indicadores.add(indicador3);

                                            // Indicador 4
                                            apiService.getExplicacionIniciativas().enqueue(new Callback<List<ExplicacionIniciativas4>>() {
                                                @Override
                                                public void onResponse(Call<List<ExplicacionIniciativas4>> call, Response<List<ExplicacionIniciativas4>> response) {
                                                    if (response.isSuccessful() && response.body() != null) {
                                                        List<ExplicacionIniciativas4> explicaciones = response.body();

                                                        IndicadorExplicacionIniciativas4 indicador4 = new IndicadorExplicacionIniciativas4(
                                                                4,
                                                                "Explicaciones de las iniciativas",
                                                                null,
                                                                null,
                                                                explicaciones
                                                        );

                                                        indicadores.add(indicador4);

                                                        // Indicador 5
                                                        apiService.getIniciativasConOdsYMetas().enqueue(new Callback<List<IniciativaConOds5>>() {
                                                            @Override
                                                            public void onResponse(Call<List<IniciativaConOds5>> call, Response<List<IniciativaConOds5>> response) {
                                                                if (response.isSuccessful() && response.body() != null) {
                                                                    List<IniciativaConOds5> iniciativas = response.body();

                                                                    List<Float> datosGrafico = new ArrayList<>();
                                                                    List<String> etiquetas = new ArrayList<>();

                                                                    for (IniciativaConOds5 iniciativa : iniciativas) {
                                                                        for (OdsConMetas5 ods : iniciativa.getOds()) {
                                                                            for (Meta5 meta : ods.getMetas()) {
                                                                                datosGrafico.add(1f);
                                                                                etiquetas.add(meta.getNombreMeta());
                                                                            }
                                                                        }
                                                                    }

                                                                    IndicadorOdsTrabajadosYSusMetas5 indicador5 = new IndicadorOdsTrabajadosYSusMetas5(
                                                                            5,
                                                                            "ODS trabajados y sus metas",
                                                                            datosGrafico,
                                                                            etiquetas,
                                                                            iniciativas
                                                                    );

                                                                    indicadores.add(indicador5);

                                                                    // Indicador 6
                                                                    apiService.getEntidadesExternas().enqueue(new Callback<List<EntidadesExternas6>>() {
                                                                        @Override
                                                                        public void onResponse(Call<List<EntidadesExternas6>> call, Response<List<EntidadesExternas6>> response) {
                                                                            if (response.isSuccessful() && response.body() != null && !response.body().isEmpty()) {
                                                                                EntidadesExternas6 entidades = response.body().get(0);

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

                                                                                // Indicador 7
                                                                                apiService.getTieneRRSS().enqueue(new Callback<List<TieneRRSS7>>() {
                                                                                    @Override
                                                                                    public void onResponse(Call<List<TieneRRSS7>> call, Response<List<TieneRRSS7>> response) {
                                                                                        if (response.isSuccessful() && response.body() != null) {
                                                                                            List<TieneRRSS7> listaRRSS = response.body();

                                                                                            IndicadorTieneRRSS7 indicador7 = new IndicadorTieneRRSS7(
                                                                                                    7,
                                                                                                    "¿Qué iniciativas tienen presencia en redes sociales?",
                                                                                                    null,
                                                                                                    null,
                                                                                                    listaRRSS
                                                                                            );

                                                                                            indicadores.add(indicador7);

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

                                                                                                                    CantProfesores10_1 profesores = response.body();

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

                                                                                                                                // Indicador 11
                                                                                                                                apiService.getDiferenciaInnovadoresYNo().enqueue(new Callback<List<DiferenciaInnovadoresYNo11>>() {
                                                                                                                                    @Override
                                                                                                                                    public void onResponse(Call<List<DiferenciaInnovadoresYNo11>> call, Response<List<DiferenciaInnovadoresYNo11>> response) {
                                                                                                                                        if (response.isSuccessful() && response.body() != null && !response.body().isEmpty()) {
                                                                                                                                            List<DiferenciaInnovadoresYNo11> diferencia = response.body();

                                                                                                                                            DiferenciaInnovadoresYNo11 dato = diferencia.get(0); // como es solo uno

                                                                                                                                            List<Float> datosDiferencia = new ArrayList<>();
                                                                                                                                            datosDiferencia.add((float) dato.getCantidadInnovadoras());
                                                                                                                                            datosDiferencia.add((float) dato.getCantidadNoInnovadoras());

                                                                                                                                            List<String> etiquetasDiferencia = new ArrayList<>();
                                                                                                                                            etiquetasDiferencia.add("Innovadoras");
                                                                                                                                            etiquetasDiferencia.add("No innovadoras");

                                                                                                                                            IndicadorDiferenciaInnovadoresYNo11 indicador11 = new IndicadorDiferenciaInnovadoresYNo11(
                                                                                                                                                    11,
                                                                                                                                                    "Diferencia entre iniciativas innovadoras y no innovadoras",
                                                                                                                                                    datosDiferencia,
                                                                                                                                                    etiquetasDiferencia,
                                                                                                                                                    diferencia // se guarda como lista por si cambia el backend en el futuro
                                                                                                                                            );

                                                                                                                                            indicadores.add(indicador11);

                                                                                                                                            // Indicador 12
                                                                                                                                            apiService.getCantHorasIniciativa().enqueue(new Callback<List<CantHorasIniciativa12>>() {
                                                                                                                                                @Override
                                                                                                                                                public void onResponse(Call<List<CantHorasIniciativa12>> call, Response<List<CantHorasIniciativa12>> response) {
                                                                                                                                                    if (response.isSuccessful() && response.body() != null) {
                                                                                                                                                        List<CantHorasIniciativa12> horasIniciativas = response.body();

                                                                                                                                                        List<Float> datosHoras = new ArrayList<>();
                                                                                                                                                        List<String> etiquetasHoras = new ArrayList<>();

                                                                                                                                                        for (CantHorasIniciativa12 iniciativa : horasIniciativas) {
                                                                                                                                                            datosHoras.add((float) iniciativa.getHorasDedicadas());
                                                                                                                                                            etiquetasHoras.add(iniciativa.getNombreIniciativa());
                                                                                                                                                        }


                                                                                                                                                        IndicadorCantHorasIniciativa12 indicador12 = new IndicadorCantHorasIniciativa12(
                                                                                                                                                                12,
                                                                                                                                                                "Horas dedicadas a cada iniciativa",
                                                                                                                                                                datosHoras,
                                                                                                                                                                etiquetasHoras,
                                                                                                                                                                horasIniciativas
                                                                                                                                                        );

                                                                                                                                                        indicadores.add(indicador12);

                                                                                                                                                        // Indicador 13
                                                                                                                                                        apiService.getHaTenidoActividad().enqueue(new Callback<List<HaTenidoActividad13>>() {
                                                                                                                                                            @Override
                                                                                                                                                            public void onResponse(Call<List<HaTenidoActividad13>> call, Response<List<HaTenidoActividad13>> response) {
                                                                                                                                                                if (response.isSuccessful() && response.body() != null) {
                                                                                                                                                                    List<HaTenidoActividad13> actividad = response.body();

                                                                                                                                                                    HaTenidoActividad13 datos = actividad.get(0); // como es solo uno

                                                                                                                                                                    List<Float> datosActividad = new ArrayList<>();
                                                                                                                                                                    datosActividad.add(Float.parseFloat(datos.getTieneActividades()));
                                                                                                                                                                    datosActividad.add(Float.parseFloat(datos.getNoTieneActividades()));

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

                                                                                                                                                                    // Finalmente devolvemos todos los indicadores ya cargados
                                                                                                                                                                    callback.onResult(indicadores);

                                                                                                                                                                } else {
                                                                                                                                                                    Log.e(TAG, "Error en getHaTenidoActividad: Respuesta vacía o error en la API");
                                                                                                                                                                    callback.onError(new Exception("Error al obtener haTenidoActividad"));
                                                                                                                                                                }
                                                                                                                                                            }

                                                                                                                                                            @Override
                                                                                                                                                            public void onFailure(Call<List<HaTenidoActividad13>> call, Throwable t) {
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
                                                                                                                                    public void onFailure(Call<List<DiferenciaInnovadoresYNo11>> call, Throwable t) {
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
                                                                                            callback.onError(new Exception("Error al obtener tieneRRSS"));
                                                                                        }
                                                                                    }

                                                                                    @Override
                                                                                    public void onFailure(Call<List<TieneRRSS7>> call, Throwable t) {
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
                                                                    Log.e(TAG, "Error en getIniciativasConOdsYMetas: Respuesta vacía o error en la API");
                                                                    callback.onError(new Exception("Error al obtener iniciativas con ODS y metas"));
                                                                }
                                                            }

                                                            @Override
                                                            public void onFailure(Call<List<IniciativaConOds5>> call, Throwable t) {
                                                                Log.e(TAG, "Fallo en getIniciativasConOdsYMetas", t);
                                                                callback.onError(t);
                                                            }
                                                        });



                                                    } else {
                                                        Log.e(TAG, "Error en getExplicacionIniciativas: Respuesta vacía o error en la API");
                                                        callback.onError(new Exception("Error al obtener explicacionIniciativas"));
                                                    }
                                                }

                                                @Override
                                                public void onFailure(Call<List<ExplicacionIniciativas4>> call, Throwable t) {
                                                    Log.e(TAG, "Fallo en getExplicacionIniciativas", t);
                                                    callback.onError(t);
                                                }
                                            });

                                        } else {
                                            callback.onError(new Exception("Error al obtener ciclos y módulos con iniciativas"));
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<List<IniciativaConCiclos3>> call, Throwable t) {
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
