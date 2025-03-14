package com.ander.aplicacioniniciativas.Activities;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SearchView;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
    private String textoBusqueda = "";
    private String fechaInicio = "";
    private String fechaFin = "";
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciativas);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        SearchView searchView = findViewById(R.id.searchView);
        EditText editFechaInicio = findViewById(R.id.editFechaInicio);
        EditText editFechaFin = findViewById(R.id.editFechaFin);

        // Obtener las iniciativas desde la API
        CutrovientosIniciativasService apiService = ApiClient.getIniciativasService();
        Call<List<Iniciativa>> call = apiService.getIniciativas(false);
        call.enqueue(new Callback<List<Iniciativa>>() {
            @Override
            public void onResponse(Call<List<Iniciativa>> call, Response<List<Iniciativa>> response) {
                if (response.isSuccessful()) {
                    iniciativas = response.body();
                    actualizarListaFiltrada();
                } else {
                    Log.e("API", "Error en la respuesta: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Iniciativa>> call, Throwable t) {
                Log.e("API", "Error en la llamada", t);
            }
        });

        // Configuración de los spinners
        configurarSpinners();

        // Configuración del buscador
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                textoBusqueda = newText.toLowerCase();
                actualizarListaFiltrada();
                return true;
            }
        });

        // Configurar el filtro de fechas
        editFechaInicio.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                fechaInicio = s.toString();
                actualizarListaFiltrada();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        editFechaFin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                fechaFin = s.toString();
                actualizarListaFiltrada();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void configurarSpinners() {
        Spinner spinnerCursos = findViewById(R.id.dropDownCursos);
        Spinner spinnerOds = findViewById(R.id.dropDownODS);

        // Configuración del Spinner Cursos
        CutrovientosIniciativasService apiService = ApiClient.getIniciativasService();
        Call<List<Curso>> callCursos = apiService.getCursos();
        callCursos.enqueue(new Callback<List<Curso>>() {
            @Override
            public void onResponse(Call<List<Curso>> call, Response<List<Curso>> response) {
                if (response.isSuccessful()) {
                    cursosList = response.body();
                    List<Curso> cursosConVacio = new ArrayList<>();
                    cursosConVacio.add(new Curso(0, "Todos los cursos"));
                    cursosConVacio.addAll(cursosList);
                    ArrayAdapter<Curso> spinnerAdapter = new ArrayAdapter<>(IniciativasActivity.this, android.R.layout.simple_spinner_item, cursosConVacio);
                    spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCursos.setAdapter(spinnerAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Curso>> call, Throwable t) {
                Log.e("API", "Error en la llamada a Cursos", t);
            }
        });

        // Configuración del Spinner ODS
        Call<List<Ods>> callOds = apiService.getOds();
        callOds.enqueue(new Callback<List<Ods>>() {
            @Override
            public void onResponse(Call<List<Ods>> call, Response<List<Ods>> response) {
                if (response.isSuccessful()) {
                    odsList = response.body();
                    List<Ods> odsConVacio = new ArrayList<>();
                    odsConVacio.add(new Ods(0, "Todos los ODS"));
                    odsConVacio.addAll(odsList);
                    ArrayAdapter<Ods> spinnerAdapter = new ArrayAdapter<>(IniciativasActivity.this, android.R.layout.simple_spinner_item, odsConVacio);
                    spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerOds.setAdapter(spinnerAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Ods>> call, Throwable t) {
                Log.e("API", "Error en la llamada a ODS", t);
            }
        });
    }

    private void actualizarListaFiltrada() {
        if (iniciativas == null) return;

        List<Iniciativa> iniciativasFiltradas = new ArrayList<>();

        for (Iniciativa iniciativa : iniciativas) {
            boolean cumpleCurso = cursoSeleccionado == null || cursoSeleccionado.getIdCurso() == 0;
            boolean cumpleOds = odsSeleccionado == null || odsSeleccionado.getIdOds() == 0;
            boolean cumpleBusqueda = textoBusqueda.isEmpty() || iniciativa.getNombre().toLowerCase().contains(textoBusqueda);
            boolean cumpleFecha = cumpleFiltroFecha(iniciativa.getFechaInicio(), iniciativa.getFechaFin());

            if (cumpleCurso && cumpleOds && cumpleBusqueda && cumpleFecha) {
                iniciativasFiltradas.add(iniciativa);
            }
        }

        adapter = new RecyclerDataAdapter(iniciativasFiltradas);
        recyclerView.setAdapter(adapter);
    }

    private boolean cumpleFiltroFecha(String fechaIni, String fechaFinal) {
        try {
            Date ini = fechaInicio.isEmpty() ? null : dateFormat.parse(fechaInicio);
            Date fin = fechaFin.isEmpty() ? null : dateFormat.parse(fechaFin);
            Date iniIniciativa = dateFormat.parse(fechaIni);
            Date finIniciativa = dateFormat.parse(fechaFinal);

            return (ini == null || !iniIniciativa.before(ini)) && (fin == null || !finIniciativa.after(fin));
        } catch (ParseException e) {
            return true;
        }
    }
}
