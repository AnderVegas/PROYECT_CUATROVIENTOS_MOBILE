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

        public RecyclerDataHolder(@NonNull View itemView) {
            super(itemView);
            dataTextTitulo = itemView.findViewById(R.id.nombreIniciativa);
            dataTextDescripcion = itemView.findViewById(R.id.descIniciativa);
            dataTextClase = itemView.findViewById(R.id.claseIniciativa);
            dataTextFecha = itemView.findViewById(R.id.fechaIniciativa);
            dataImage = itemView.findViewById(R.id.imagenIniciativa);
        }

        public void asignData(Iniciativa iniciativa) {
            dataTextTitulo.setText(iniciativa.getNombre());
            dataTextDescripcion.setText(iniciativa.getProducto_final());

            String curso = "";
            // Obtener el nombre del curso y quitar "Clase de " si ya está incluido
            if (!iniciativa.getModulos().isEmpty() && iniciativa.getModulos().get(0).getCurso() != null) {
                curso = iniciativa.getModulos().get(0).getCurso().getNombre();

                String prefix = "Clase de ";
                if (curso.toLowerCase().startsWith(prefix.toLowerCase())) {
                    curso = curso.substring(prefix.length());
                }
                // Mostrar "Clase de" en la primera línea y el nombre de la asignatura en la segunda
                dataTextClase.setText("Clase de\n" + curso);
            } else {
                curso = "Sin clase asignada";
            }

            // Mostrar solo la fecha (sin la hora)
            dataTextFecha.setText(iniciativa.getFechaInicio().split(" ")[0]);

            Context context = itemView.getContext();
            String nombreImagen = iniciativa.getImagen();
            int idImagen = context.getResources().getIdentifier(nombreImagen, "drawable", context.getPackageName());
            dataImage.setImageResource(idImagen);
        }
    }
}
