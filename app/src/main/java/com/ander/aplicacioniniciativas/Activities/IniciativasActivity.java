package com.ander.aplicacioniniciativas.Activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ander.aplicacioniniciativas.Adapters.RecyclerDataAdapter;
import com.ander.aplicacioniniciativas.App.ApiClient;
import com.ander.aplicacioniniciativas.App.CutrovientosIniciativasService;
import com.ander.aplicacioniniciativas.Models.Curso;
import com.ander.aplicacioniniciativas.Models.Iniciativa;
import com.ander.aplicacioniniciativas.Models.Meta;
import com.ander.aplicacioniniciativas.Models.Modulo;
import com.ander.aplicacioniniciativas.Models.Ods;
import com.ander.aplicacioniniciativas.R;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IniciativasActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerDataAdapter adapter;
    private List<Iniciativa> iniciativas;
    private List<Curso> cursosList;
    private List<Ods> odsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciativas);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Obtener las iniciativas desde la API
        CutrovientosIniciativasService apiService = ApiClient.getIniciativasService();
        Call<List<Iniciativa>> call = apiService.getIniciativas(false);
        call.enqueue(new Callback<List<Iniciativa>>() {
            @Override
            public void onResponse(Call<List<Iniciativa>> call, Response<List<Iniciativa>> response) {
                if (response.isSuccessful()) {
                    iniciativas = response.body();
                    adapter = new RecyclerDataAdapter(iniciativas);
                    recyclerView.setAdapter(adapter);
                } else {
                    Log.e("Agenda2030CuatrovientosAPI", "Error en la respuesta: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Iniciativa>> call, Throwable t) {
                Log.e("Agenda2030CuatrovientosAPI", "Error en la llamada", t);
            }
        });








        // Manejo del Spinner para Cursos
        Spinner spinnerCursos = findViewById(R.id.dropDownCursos);
        CutrovientosIniciativasService apiServiceCursos = ApiClient.getIniciativasService();
        Call<List<Curso>> callCursos = apiServiceCursos.getCursos();

        callCursos.enqueue(new Callback<List<Curso>>() {
            @Override
            public void onResponse(Call<List<Curso>> call, Response<List<Curso>> response) {
                if (response.isSuccessful()) {
                    cursosList = response.body();

                    // Añadir un curso en blanco al inicio de la lista
                    List<Curso> cursosConVacio = new ArrayList<>();
                    cursosConVacio.add(new Curso(0, "Todos los cursos")); // "Curso vacío"
                    cursosConVacio.addAll(cursosList);

                    ArrayAdapter<Curso> spinnerAdapter = new ArrayAdapter<>(IniciativasActivity.this, android.R.layout.simple_spinner_item, cursosConVacio);
                    spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCursos.setAdapter(spinnerAdapter);
                } else {
                    Log.e("Agenda2030CuatrovientosAPI", "Error en la respuesta de Cursos: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Curso>> call, Throwable t) {
                Log.e("Agenda2030CuatrovientosAPI", "Error en la llamada a Cursos", t);
            }
        });

        spinnerCursos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                Curso selectedCurso = (Curso) parentView.getItemAtPosition(position);

                if (selectedCurso != null && selectedCurso.getIdCurso() != 0) {
                    List<Iniciativa> iniciativasFiltradas = filtrarIniciativasPorCurso(iniciativas, selectedCurso);
                    if (iniciativasFiltradas.isEmpty()) {
                        Log.d("Iniciativas", "No se encontraron iniciativas para este curso.");
                    }
                    adapter = new RecyclerDataAdapter(iniciativasFiltradas);
                    recyclerView.setAdapter(adapter);
                } else {
                    adapter = new RecyclerDataAdapter(iniciativas);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                adapter = new RecyclerDataAdapter(iniciativas);
                recyclerView.setAdapter(adapter);
            }
        });









        // Manejo del Spinner para Ods
        Spinner spinnerOds = findViewById(R.id.dropDownODS);
        CutrovientosIniciativasService apiServiceOds = ApiClient.getIniciativasService();
        Call<List<Ods>> callOds = apiServiceOds.getOds();

        callOds.enqueue(new Callback<List<Ods>>() {
            @Override
            public void onResponse(Call<List<Ods>> call, Response<List<Ods>> response) {
                if (response.isSuccessful()) {
                    odsList = response.body();

                    // Añadir un ods en blanco al inicio de la lista
                    List<Ods> odsConVacio = new ArrayList<>();
                    odsConVacio.add(new Ods(0, "Todos los ods")); // "Ods vacío"
                    odsConVacio.addAll(odsList);

                    ArrayAdapter<Ods> spinnerAdapter = new ArrayAdapter<>(IniciativasActivity.this, android.R.layout.simple_spinner_item, odsConVacio);
                    spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerOds.setAdapter(spinnerAdapter);
                } else {
                    Log.e("Agenda2030CuatrovientosAPI", "Error en la respuesta de Ods: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Ods>> call, Throwable t) {
                Log.e("Agenda2030CuatrovientosAPI", "Error en la llamada a Ods", t);
            }
        });

        spinnerOds.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                Ods selectedOds = (Ods) parentView.getItemAtPosition(position);

                if (selectedOds != null && selectedOds.getIdOds() != 0) {
                    List<Iniciativa> iniciativasFiltradas = filtrarIniciativasPorOds(iniciativas, selectedOds);
                    if (iniciativasFiltradas.isEmpty()) {
                        Log.d("Iniciativas", "No se encontraron iniciativas para este ods.");
                    }
                    adapter = new RecyclerDataAdapter(iniciativasFiltradas);
                    recyclerView.setAdapter(adapter);
                } else {
                    adapter = new RecyclerDataAdapter(iniciativas);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                adapter = new RecyclerDataAdapter(iniciativas);
                recyclerView.setAdapter(adapter);
            }
        });
    }






    // Filtrar iniciativas por el curso seleccionado
    private List<Iniciativa> filtrarIniciativasPorCurso(List<Iniciativa> todasLasIniciativas, Curso cursoSeleccionado) {
        List<Iniciativa> iniciativasFiltradas = new ArrayList<>();

            for (Iniciativa iniciativa : todasLasIniciativas) {
                boolean tieneModuloDelCurso = false;
                for (Modulo modulo : iniciativa.getModulos()) {
                    if (modulo.getCurso() != null && modulo.getCurso().getIdCurso() == cursoSeleccionado.getIdCurso()) {
                        tieneModuloDelCurso = true;
                        break;
                    }
                }
                if (tieneModuloDelCurso) {
                    iniciativasFiltradas.add(iniciativa);
                }
            }

        return iniciativasFiltradas;
    }



    // Filtrar iniciativas por el ods seleccionado
    private List<Iniciativa> filtrarIniciativasPorOds(List<Iniciativa> todasLasIniciativas, Ods odsSeleccionado) {
        List<Iniciativa> iniciativasFiltradas = new ArrayList<>();

        for (Iniciativa iniciativa : todasLasIniciativas) {
            boolean tieneMetaDelOds = false;
            for (Meta meta : iniciativa.getMetas()) {
                if (meta.getOds() != null && meta.getOds().getIdOds() == odsSeleccionado.getIdOds()) {
                    tieneMetaDelOds = true;
                    break;
                }
            }
            if (tieneMetaDelOds) {
                iniciativasFiltradas.add(iniciativa);
            }
        }

        return iniciativasFiltradas;
    }


}
