package com.ander.aplicacioniniciativas.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ander.aplicacioniniciativas.Models.EntidadExterna;
import com.ander.aplicacioniniciativas.Models.Iniciativa;
import com.ander.aplicacioniniciativas.Models.Profesor;
import com.ander.aplicacioniniciativas.R;
import com.bumptech.glide.Glide;

import java.io.Serializable;

public class IniciativaDetalleActivity extends AppCompatActivity implements Serializable {

    private ImageView imageCasa;
    private ImageView imageIniciativa;
    private TextView textNombre, textFechas, textTipoHoras, textDescripcion, textProfesores, textEntidades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        // Boton para volver al inicio
        imageCasa = findViewById(R.id.imageViewCasa);

        // Detalles de la iniciativa
        imageIniciativa = findViewById(R.id.imageIniciativa);
        textNombre = findViewById(R.id.textNombre);
        textFechas = findViewById(R.id.textFechas);
        textTipoHoras = findViewById(R.id.textTipoHoras);
        textDescripcion = findViewById(R.id.textDescripcion);
        textProfesores = findViewById(R.id.textProfesores);
        textEntidades = findViewById(R.id.textEntidades);

        // Volver al incio
        imageCasa.setOnClickListener(view -> {
            finish();
        });

        // Recibir iniciativa desde el intent
        Iniciativa iniciativa = (Iniciativa) getIntent().getSerializableExtra("iniciativa");

        if (iniciativa != null) {
            textNombre.setText(iniciativa.getNombre());
            textFechas.setText("Del " + iniciativa.getFechaInicio() + " al " + iniciativa.getFechaFin());
            textTipoHoras.setText(iniciativa.getTipo() + " - " + iniciativa.getHoras() + " horas");
            textDescripcion.setText(iniciativa.getProducto_final());

            // Mostrar profesores
            StringBuilder profs = new StringBuilder("Profesores: ");
            for (Profesor p : iniciativa.getProfesores()) {
                profs.append(p.getNombre()).append(", ");
            }
            textProfesores.setText(profs.toString());

            // Mostrar entidades externas
            StringBuilder entidades = new StringBuilder("Entidades: ");
            for (EntidadExterna e : iniciativa.getEntidades_externas()) {
                entidades.append(e.getNombre()).append(", ");
            }
            textEntidades.setText(entidades.toString());

            // Cargar imagen (con Glide, por ejemplo)
            Glide.with(this)
                    .load(iniciativa.getImagen())
                    .placeholder(R.drawable.cargando) // pon uno por defecto
                    .into(imageIniciativa);
        }
    }
}

