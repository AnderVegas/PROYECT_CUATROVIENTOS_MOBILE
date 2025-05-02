package com.ander.aplicacioniniciativas.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ander.aplicacioniniciativas.Adapters.RecyclerDataAdapter;
import com.ander.aplicacioniniciativas.App.ApiClient;
import com.ander.aplicacioniniciativas.App.CutrovientosIniciativasService;
import com.ander.aplicacioniniciativas.Models.Clase;
import com.ander.aplicacioniniciativas.Models.Iniciativa;
import com.ander.aplicacioniniciativas.Models.Modulo;
import com.ander.aplicacioniniciativas.Models.Ods;
import com.ander.aplicacioniniciativas.R;
import com.google.android.material.navigation.NavigationView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IniciativasActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerViewIniciativas;
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
    private boolean favoritos = false;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolBar;
    private ImageView botonIndicadores;
    private LinearLayout headerFecha;
    private LinearLayout filtrosDateContainer;
    private ImageView iconToggleFecha;
    private LinearLayout headerClaseODS;
    private LinearLayout filtrosClaseODSContainer;
    private ImageView iconToggleClaseODS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciativas);

        // Recycler de iniciativas
        recyclerViewIniciativas = findViewById(R.id.recyclerView);
        // GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewIniciativas.setLayoutManager(layoutManager);

        // Botones para cambiar entre favoritos y todas las iniciativas
        TextView viewIniciativas = findViewById(R.id.textViewIniciativas);
        TextView viewFavoritos = findViewById(R.id.textViewFavoritos);

        // Inicializar filtros para que aparezcan
        CardView cardViewFiltros = findViewById(R.id.cardViewFiltros);
        // LinearLayout searchAndFiltersLayout = findViewById(R.id.searchAndFiltersLayout);
        ImageView imageLupa = findViewById(R.id.imageViewlupa);

        SearchView searchView = findViewById(R.id.searchView);
        EditText editFechaInicio = findViewById(R.id.editFechaInicio);
        EditText editFechaFin = findViewById(R.id.editFechaFin);

        // Lineas de eleccion iniciativas y favoritos
        LinearLayout lineaIniciativas = findViewById(R.id.lineaIniciativa);
        LinearLayout lineaFavoritos = findViewById(R.id.lineaFavorito);

        // Parte del menú desplegable
        drawerLayout = findViewById(R.id.drawer_layout);
        toolBar = findViewById(R.id.toggleDesplegable);
        navigationView = findViewById(R.id.nav_view);

        setSupportActionBar(toolBar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolBar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        // Boton para pantalla de indicadores
        botonIndicadores = findViewById(R.id.imageViewIndicadores);
        botonIndicadores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IniciativasActivity.this,IndicadoresActivity.class);
                startActivity(intent);
            }
        });

        // Boton desplegable de filtro fecha
        headerFecha = findViewById(R.id.headerFecha);
        filtrosDateContainer = findViewById(R.id.filtrosFechaContainer);
        iconToggleFecha = findViewById(R.id.iconToggleFecha);
        headerFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (filtrosDateContainer.getVisibility() == View.GONE) {
                    filtrosDateContainer.setVisibility(View.VISIBLE);
                    iconToggleFecha.setImageResource(R.drawable.minimizar);
                } else {
                    filtrosDateContainer.setVisibility(View.GONE);
                    iconToggleFecha.setImageResource(R.drawable.maximizar);
                }
            }
        });

        // Boton desplegable de filtro ODS y Clase
        headerClaseODS = findViewById(R.id.headerClaseODS);
        filtrosClaseODSContainer = findViewById(R.id.filtrosClaseODSContainer);
        iconToggleClaseODS = findViewById(R.id.iconToggleClaseODS);
        headerClaseODS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (filtrosClaseODSContainer.getVisibility() == View.GONE) {
                    filtrosClaseODSContainer.setVisibility(View.VISIBLE);
                    iconToggleClaseODS.setImageResource(R.drawable.minimizar);
                } else {
                    filtrosClaseODSContainer.setVisibility(View.GONE);
                    iconToggleClaseODS.setImageResource(R.drawable.maximizar);
                }
            }
        });

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

        // Configurar el botón para mostrar los filtros
        imageLupa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cambiar la visibilidad de los filtros
                if (cardViewFiltros.getVisibility() == View.GONE) {
                    cardViewFiltros.setVisibility(View.VISIBLE);
                } else {
                    cardViewFiltros.setVisibility(View.GONE);
                }
            }
        });

        // Mostrar recicler de todas las iniciativas
        viewIniciativas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                favoritos = false;
                actualizarListaFiltrada();
                lineaIniciativas.setBackgroundColor(Color.parseColor("#333333"));
                lineaFavoritos.setBackgroundColor(Color.TRANSPARENT);
            }
        });

        // Mostrar iniciativas favoritas
        viewFavoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                favoritos = true;
                actualizarListaFiltrada();
                lineaIniciativas.setBackgroundColor(Color.TRANSPARENT);
                lineaFavoritos.setBackgroundColor(Color.parseColor("#333333"));
            }
        });

        // Configuración de los spinners
        configurarSpinners();

        // Listener para el spinner de Clases
        Spinner spinnerClases = findViewById(R.id.dropDownCursos);
        spinnerClases.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Clase claseSeleccionadaTmp = (Clase) parent.getItemAtPosition(position);
                if (claseSeleccionadaTmp != null && claseSeleccionadaTmp.getIdCurso() != 0) {
                    claseSeleccionado = claseSeleccionadaTmp;
                } else {
                    claseSeleccionado = null;
                }

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

            // Filtrado por Clase
            boolean cumpleCurso = false;
            if (claseSeleccionado == null || claseSeleccionado.getIdCurso() == 0) {
                cumpleCurso = true;
            } else {
                if (iniciativa.getModulos() != null && !iniciativa.getModulos().isEmpty()) {
                    for (Modulo modulo : iniciativa.getModulos()) {
                        List<Clase> clasesModulo = modulo.getCurso();
                        if (clasesModulo != null) {
                            for (Clase clase : clasesModulo) {
                                if (clase.getIdCurso() == claseSeleccionado.getIdCurso()) {
                                    cumpleCurso = true;
                                    break;
                                }
                            }
                        }
                        if (cumpleCurso) break;
                    }
                }


            }

            // Filtrado por ODS
            boolean cumpleOds = false;
            if (odsSeleccionado == null || odsSeleccionado.getIdOds() == 0) {
                cumpleOds = true;
            } else {
                // Verificamos que la iniciativa tenga metas y que la primera meta tenga un ODS asignado
                if (!iniciativa.getMetas().isEmpty() && iniciativa.getMetas().get(0).getOds() != null) {
                    cumpleOds = (iniciativa.getMetas().get(0).getOds().getIdOds() == odsSeleccionado.getIdOds());
                }
            }

            if (cumpleBusqueda && cumpleFecha && cumpleCurso && cumpleOds) {
                iniciativasFiltradas.add(iniciativa);
            }

        }

        if (favoritos)
        {
            List<Iniciativa> iniciativasFavoritas = new ArrayList<>();
            for (Iniciativa iniciativa : iniciativasFiltradas) {
                if (iniciativa.isEsFavorito()) {
                    iniciativasFavoritas.add(iniciativa);
                }
            }
            iniciativasFiltradas = iniciativasFavoritas;
        }

        adapter = new RecyclerDataAdapter(iniciativasFiltradas, new RecyclerDataAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Iniciativa iniciativa) {
                Intent intent = new Intent(IniciativasActivity.this, IniciativaDetalleActivity.class);

                intent.putExtra("iniciativa", iniciativa);
                startActivity(intent);
            }
        });
        recyclerViewIniciativas.setAdapter(adapter);

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

    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Acción para "Inicio"
        } else if (id == R.id.nav_indicadores) {
            startActivity(new Intent(this, IndicadoresActivity.class));
        } else if (id == R.id.nav_login) {
            startActivity(new Intent(this, MainActivity.class));
        } else if (id == R.id.nav_logout) {
            startActivity(new Intent(this, MainActivity.class));
        } else if (id == R.id.nav_Profile) {
            // Acción para "Perfil"
        } else if (id == R.id.nav_share) {
            // Acción para "Compartir"
        } else if (id == R.id.nav_rate) {
            // Acción para "Valorar"
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}
