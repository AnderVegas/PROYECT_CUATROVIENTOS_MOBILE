package com.ander.aplicacioniniciativas.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ander.aplicacioniniciativas.Models.Indicador;
import com.ander.aplicacioniniciativas.R;

import java.util.List;

public class RecyclerDataAdapterIndicadores extends RecyclerView.Adapter<RecyclerDataAdapterIndicadores.RecyclerDataHolder> {

    private List<Indicador> listIndicadores;
    // private OnClickListener listener;

    public RecyclerDataAdapterIndicadores(List<Indicador> listIndicadores) {
        this.listIndicadores = listIndicadores;
    }

    @NonNull
    @Override
    public RecyclerDataAdapterIndicadores.RecyclerDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.indicador_item, parent, false);
        return new RecyclerDataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerDataAdapterIndicadores.RecyclerDataHolder holder, int position) {
        holder.asignData(listIndicadores.get(position));
    }

    @Override
    public int getItemCount() {
        return listIndicadores.size();
    }

    public class RecyclerDataHolder extends RecyclerView.ViewHolder {

        private TextView textDesc;
        private ImageView grafico;

        public RecyclerDataHolder(@NonNull View itemView) {
            super(itemView);
            textDesc = itemView.findViewById(R.id.tituloIndicador);
            grafico = itemView.findViewById(R.id.graficoIndicador);
        }

        public void asignData(Indicador indicador) {
            textDesc.setText(indicador.getDescripcion());
        }
    }
}
