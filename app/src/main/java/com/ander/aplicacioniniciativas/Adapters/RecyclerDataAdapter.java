package com.ander.aplicacioniniciativas.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ander.aplicacioniniciativas.Models.Iniciativa;
import com.ander.aplicacioniniciativas.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

public class RecyclerDataAdapter extends RecyclerView.Adapter<RecyclerDataAdapter.RecyclerDataHolder>{

    private List<Iniciativa> listData;

    public RecyclerDataAdapter(List<Iniciativa> listData){
        this.listData = listData;
    }

    @NonNull
    @Override
    public RecyclerDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.iniciativa_item, parent, false);
        return new RecyclerDataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerDataHolder holder, int position) {
        holder.asignData(listData.get(position));
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class RecyclerDataHolder extends RecyclerView.ViewHolder {
        private TextView dataTextTitulo;
        private TextView dataTextDescripcion;
        private ImageView dataImage;
        private TextView dataTextClase;
        private TextView dataTextFecha;
        private ImageView btnFavorito;

        public RecyclerDataHolder(@NonNull View itemView) {
            super(itemView);
            dataTextTitulo = itemView.findViewById(R.id.nombreIniciativa);
            dataTextDescripcion = itemView.findViewById(R.id.descIniciativa);
            dataTextClase = itemView.findViewById(R.id.claseIniciativa);
            dataTextFecha = itemView.findViewById(R.id.fechaIniciativa);
            dataImage = itemView.findViewById(R.id.imagenIniciativa);
            btnFavorito = itemView.findViewById(R.id.btnFavorito);
        }

        public void asignData(Iniciativa iniciativa) {
            dataTextTitulo.setText(iniciativa.getNombre());
            dataTextDescripcion.setText(iniciativa.getProducto_final());

            String curso = "";
            if (!iniciativa.getModulos().isEmpty() && iniciativa.getModulos().get(0).getCurso() != null) {
                curso = iniciativa.getModulos().get(0).getCurso().getNombre();
                String prefix = "Clase de ";
                if (curso.toLowerCase().startsWith(prefix.toLowerCase())) {
                    curso = curso.substring(prefix.length());
                }
                dataTextClase.setText("Clase de " + curso);
            } else {
                curso = "Sin clase asignada";
            }

            dataTextFecha.setText(iniciativa.getFechaInicio().split(" ")[0]);

            // Cargar imagen desde URL con Glide
            Glide.with(itemView.getContext())
                    .load(iniciativa.getImagen())
                    .diskCacheStrategy(DiskCacheStrategy.ALL) // Para mejor rendimiento
                    .placeholder(R.drawable.cargando) // Imagen de carga
                    .error(R.drawable.imageerror) // Imagen en caso de error
                    .into(dataImage);

            // Icono dependiendo de si es favorito o no
            actualizarIconoFavorito(iniciativa.isEsFavorito());

            // Listener para cambiar favorito
            btnFavorito.setOnClickListener(v -> {
                iniciativa.setEsFavorito(!iniciativa.isEsFavorito());
                actualizarIconoFavorito(iniciativa.isEsFavorito());
            });
        }

        private void actualizarIconoFavorito(boolean esFavorito) {
            if (esFavorito) {
                btnFavorito.setImageResource(R.drawable.guardadolleno);
            } else {
                btnFavorito.setImageResource(R.drawable.guardadovacio);
            }
        }
    }
}
