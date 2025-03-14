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
    private Ods odsSeleccionado;
    private Curso cursoSeleccionado;

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






        // Iniciar Spinner para Cursos
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

        // Iniciar Spinner para Ods
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







        // Spinner de curso
        spinnerCursos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                cursoSeleccionado = (Curso) parentView.getItemAtPosition(position);

                if (cursoSeleccionado != null && cursoSeleccionado.getIdCurso() != 0) {
                    List<Iniciativa> iniciativasFiltradas = filtrarIniciativas(iniciativas, cursoSeleccionado, odsSeleccionado);
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

        // Spinner de Ods
        spinnerOds.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                odsSeleccionado = (Ods) parentView.getItemAtPosition(position);

                if (odsSeleccionado != null && odsSeleccionado.getIdOds() != 0) {
                    List<Iniciativa> iniciativasFiltradas = filtrarIniciativas(iniciativas, cursoSeleccionado, odsSeleccionado);
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







    // Filtrar iniciativas
    private List<Iniciativa> filtrarIniciativas(List<Iniciativa> todasLasIniciativas, Curso cursoSeleccionado, Ods odsSeleccionado) {
        if (todasLasIniciativas == null || todasLasIniciativas.isEmpty()) {
            return new ArrayList<>();
        }

        List<Iniciativa> iniciativasFiltradas = new ArrayList<>();

        for (Iniciativa iniciativa : todasLasIniciativas) {
            boolean cumpleCurso = (cursoSeleccionado == null || cursoSeleccionado.getIdCurso() == 0);
            boolean cumpleOds = (odsSeleccionado == null || odsSeleccionado.getIdOds() == 0);

            // Verificar si cumple con el filtro de curso
            if (!cumpleCurso) {
                for (Modulo modulo : iniciativa.getModulos()) {
                    if (modulo.getCurso() != null && modulo.getCurso().getIdCurso() == cursoSeleccionado.getIdCurso()) {
                        cumpleCurso = true;
                        break;
                    }
                }
            }

            // Verificar si cumple con el filtro de ODS
            if (!cumpleOds) {
                for (Meta meta : iniciativa.getMetas()) {
                    if (meta.getOds() != null && meta.getOds().getIdOds() == odsSeleccionado.getIdOds()) {
                        cumpleOds = true;
                        break;
                    }
                }
            }

            // Si cumple al menos un criterio (según los filtros aplicados), se agrega a la lista
            if (cumpleCurso && cumpleOds) {
                iniciativasFiltradas.add(iniciativa);
            }
        }

        return iniciativasFiltradas;
    }


}
