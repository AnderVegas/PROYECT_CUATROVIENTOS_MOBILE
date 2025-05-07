package com.ander.aplicacioniniciativas.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.ander.aplicacioniniciativas.Adapters.RecyclerDataAdapterIndicadores;
import com.ander.aplicacioniniciativas.Models.Indicador;
import com.ander.aplicacioniniciativas.R;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class PerfilActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolBar;
    private ImageView botonIniciativas;
    private ImageView botonPerfil;
    private ImageView botonIndicadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

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
            Intent intent = new Intent(PerfilActivity.this, IniciativasActivity.class);
            startActivity(intent);
        });

        // Boton para pantalla de Indicadores
        botonIndicadores = findViewById(R.id.imageViewIndicadores);
        botonIndicadores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PerfilActivity.this,IndicadoresActivity.class);
                startActivity(intent);
            }
        });

        // Boton para pantalla de perfil
        botonPerfil = findViewById(R.id.imageViewPerfil);
        botonPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PerfilActivity.this,PerfilActivity.class);
                startActivity(intent);
            }
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
            startActivity(new Intent(this, IndicadoresActivity.class));
        } else if (id == R.id.nav_login) {
            startActivity(new Intent(this, MainActivity.class));
        } else if (id == R.id.nav_logout) {
            startActivity(new Intent(this, MainActivity.class));
        } else if (id == R.id.nav_Profile) {
            startActivity(new Intent(this, PerfilActivity.class));
        } else if (id == R.id.nav_share) {
            // Acción para "Compartir"
        } else if (id == R.id.nav_rate) {
            // Acción para "Valorar"
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}
