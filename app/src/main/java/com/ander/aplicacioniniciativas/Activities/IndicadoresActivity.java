package com.ander.aplicacioniniciativas.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ander.aplicacioniniciativas.Adapters.RecyclerDataAdapter;
import com.ander.aplicacioniniciativas.Adapters.RecyclerDataAdapterIndicadores;
import com.ander.aplicacioniniciativas.Models.Indicador;
import com.ander.aplicacioniniciativas.R;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class IndicadoresActivity extends AppCompatActivity {

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

        listIndicadores = ServiceIndicadores.getIndicadores();

        // Recycler
        recyclerViewIndicadores = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewIndicadores.setLayoutManager(layoutManager);

        adapter = new RecyclerDataAdapterIndicadores(listIndicadores);
        recyclerViewIndicadores.setAdapter(adapter);

        // Parte del menú desplegable
        drawerLayout = findViewById(R.id.drawer_layout);
        toolBar = findViewById(R.id.toggleDesplegable);
        navigationView = findViewById(R.id.nav_view);

        setSupportActionBar(toolBar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolBar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Boton para pantalla de iniciativas
        botonIniciativas = findViewById(R.id.imageViewCasa);
        botonIniciativas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IndicadoresActivity.this,IniciativasActivity.class);
                startActivity(intent);
            }
        });

    }
}
