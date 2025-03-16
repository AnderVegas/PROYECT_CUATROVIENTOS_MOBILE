package com.ander.aplicacioniniciativas.Activities;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ander.aplicacioniniciativas.Adapters.RecyclerDataAdapter;
import com.ander.aplicacioniniciativas.App.ApiClient;
import com.ander.aplicacioniniciativas.App.CutrovientosIniciativasService;
import com.ander.aplicacioniniciativas.Models.Clase;
import com.ander.aplicacioniniciativas.Models.Iniciativa;
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
    private List<Clase> clasesList;
    private List<Ods> odsList;
    private Ods odsSeleccionado;
    private Clase claseSeleccionado;
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

        // Listener para el spinner de Clases
        Spinner spinnerClases = findViewById(R.id.dropDownCursos);
        spinnerClases.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                claseSeleccionado = (Clase) parent.getItemAtPosition(position);
                actualizarListaFiltrada();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                claseSeleccionado = null;
                actualizarListaFiltrada();
            }
        });

        // Listener para el spinner de ODS
        Spinner spinnerOds = findViewById(R.id.dropDownODS);
        spinnerOds.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                odsSeleccionado = (Ods) parent.getItemAtPosition(position);
                actualizarListaFiltrada();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                odsSeleccionado = null;
                actualizarListaFiltrada();
            }
        });

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
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                fechaInicio = s.toString();
                actualizarListaFiltrada();
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });

        editFechaFin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                fechaFin = s.toString();
                actualizarListaFiltrada();
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
    }

    private void configurarSpinners() {
        Spinner spinnerClases = findViewById(R.id.dropDownCursos);
        Spinner spinnerOds = findViewById(R.id.dropDownODS);

        CutrovientosIniciativasService apiService = ApiClient.getIniciativasService();
        Call<List<Clase>> callClases = apiService.getCursos();
        callClases.enqueue(new Callback<List<Clase>>() {
            @Override
            public void onResponse(Call<List<Clase>> call, Response<List<Clase>> response) {
                if (response.isSuccessful()) {
                    clasesList = response.body();
                    List<Clase> claseConVacio = new ArrayList<>();
                    claseConVacio.add(new Clase(0, "Todos las Clases"));
                    claseConVacio.addAll(clasesList);
                    ArrayAdapter<Clase> spinnerAdapter = new ArrayAdapter<>(IniciativasActivity.this, android.R.layout.simple_spinner_item, claseConVacio);
                    spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerClases.setAdapter(spinnerAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Clase>> call, Throwable t) {
                Log.e("API", "Error en la llamada a Clases", t);
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
                    // ODS con id 0 se usa para representar "Todos"
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
            // Filtrado por nombre (búsqueda)
            boolean cumpleBusqueda = textoBusqueda.isEmpty() || iniciativa.getNombre().toLowerCase().contains(textoBusqueda);
            // Filtrado por fechas
            boolean cumpleFecha = cumpleFiltroFecha(iniciativa.getFechaInicio(), iniciativa.getFechaFin());

            // Filtrado por Clase (suponiendo que el primer módulo indica la clase de la iniciativa)
            boolean cumpleCurso = false;
            if (claseSeleccionado == null || claseSeleccionado.getIdCurso() == 0) {
                cumpleCurso = true;
            } else {
                if (iniciativa.getModulos() != null && !iniciativa.getModulos().isEmpty()) {
                    int idCurso = iniciativa.getModulos().get(0).getCurso().getIdCurso();
                    cumpleCurso = (idCurso == claseSeleccionado.getIdCurso());
                }
            }

            // Filtrado por ODS (suponiendo que la iniciativa tiene asignado un ODS)
            boolean cumpleOds = false;
            if (odsSeleccionado == null || odsSeleccionado.getIdOds() == 0) {
                cumpleOds = true;
            } else {
                if (iniciativa.getMetas().get(0).getOds() != null) {
                    cumpleOds = (iniciativa.getMetas().get(0).getOds().getIdOds() == odsSeleccionado.getIdOds());
                }
            }

            if (cumpleBusqueda && cumpleFecha && cumpleCurso && cumpleOds) {
                iniciativasFiltradas.add(iniciativa);
            }
        }

        adapter = new RecyclerDataAdapter(iniciativasFiltradas);
        recyclerView.setAdapter(adapter);
    }

    private boolean cumpleFiltroFecha(String fechaIni, String fechaFinal) {
        try {
            // Parsear los filtros de fecha (solo fecha, sin hora)
            Date iniFiltro = fechaInicio.isEmpty() ? null : dateFormat.parse(fechaInicio);
            Date finFiltro = fechaFin.isEmpty() ? null : dateFormat.parse(fechaFin);

            // Extraer solo la parte de la fecha (yyyy-MM-dd) de las fechas de la iniciativa
            String fechaIniSolo = fechaIni.length() >= 10 ? fechaIni.substring(0, 10) : fechaIni;
            String fechaFinSolo = fechaFinal.length() >= 10 ? fechaFinal.substring(0, 10) : fechaFinal;

            Date iniIniciativa = dateFormat.parse(fechaIniSolo);
            Date finIniciativa = dateFormat.parse(fechaFinSolo);

            return (iniFiltro == null || !iniIniciativa.before(iniFiltro)) &&
                    (finFiltro == null || !finIniciativa.after(finFiltro));
        } catch (ParseException e) {
            e.printStackTrace();
            return true;
        }
    }
}
