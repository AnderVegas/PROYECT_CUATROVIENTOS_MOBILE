package com.ander.aplicacioniniciativas.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ander.aplicacioniniciativas.Adapters.RecyclerDataAdapter;
import com.ander.aplicacioniniciativas.Adapters.RecyclerDataAdapterIndicadores;
import com.ander.aplicacioniniciativas.App.ApiClient;
import com.ander.aplicacioniniciativas.App.CutrovientosIniciativasService;
import com.ander.aplicacioniniciativas.Models.Indicador;
import com.ander.aplicacioniniciativas.R;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class IndicadoresActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerViewIndicadores;
    private RecyclerDataAdapterIndicadores adapter;
    private List<Indicador> listIndicadores;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolBar;
    private ImageView botonIniciativas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.indicadores_activity);

        // Inicializar recycler
        recyclerViewIndicadores = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewIndicadores.setLayoutManager(layoutManager);

        // Instanciar Retrofit y el servicio
        CutrovientosIniciativasService api = ApiClient.getIniciativasService();
        ServiceIndicadores service = new ServiceIndicadores(api);

        // Obtener indicadores desde la API (datos mixtos)
        service.getIndicadores(new ServiceIndicadores.IndicadoresCallback() {
            @Override
            public void onResult(List<Indicador> indicadores) {
                listIndicadores = indicadores;

                // Crear y asignar el adapter
                adapter = new RecyclerDataAdapterIndicadores(listIndicadores);
                recyclerViewIndicadores.setAdapter(adapter);
            }

            @Override
            public void onError(Throwable t) {
                // Manejo básico de error
                t.printStackTrace();
            }
        });

        // Menú desplegable
        drawerLayout = findViewById(R.id.drawer_layout);
        toolBar = findViewById(R.id.toggleDesplegable);
        navigationView = findViewById(R.id.nav_view);
        setSupportActionBar(toolBar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolBar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        // Botón de navegación a iniciativas
        botonIniciativas = findViewById(R.id.imageViewCasa);
        botonIniciativas.setOnClickListener(view -> {
            Intent intent = new Intent(IndicadoresActivity.this, IniciativasActivity.class);
            startActivity(intent);
        });
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
            startActivity(new Intent(this, IniciativasActivity.class));
        } else if (id == R.id.nav_indicadores) {

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
