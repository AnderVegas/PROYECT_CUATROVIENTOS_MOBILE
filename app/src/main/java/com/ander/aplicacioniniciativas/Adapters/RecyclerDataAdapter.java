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
    private OnItemClickListener itemListener;

    public RecyclerDataAdapter(List<Iniciativa> listData){
        this.listData = listData;
    }

    @NonNull
    @Override
    public RecyclerDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.iniciativa_item,parent,false);
        return new RecyclerDataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerDataHolder holder, int position) {
        holder.asignData(listData.get(position),itemListener);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class RecyclerDataHolder extends RecyclerView.ViewHolder {
        private TextView dataTextTitulo;
        private TextView dataTextDescripcion;
        private ImageView dataImage;

        public RecyclerDataHolder(@NonNull View itemView) {
            super(itemView);
            dataTextTitulo = itemView.findViewById(R.id.nombreIniciativa);
            dataTextDescripcion = itemView.findViewById(R.id.descIniciativa);
            dataImage = itemView.findViewById(R.id.imagenIniciativa);
        }

        public void asignData(Iniciativa iniciativa, final OnItemClickListener onItemClickListener) {
            dataTextTitulo.setText(iniciativa.getNombre());
            dataTextDescripcion.setText(iniciativa.getProducto_final());

            Context context = itemView.getContext();
            String nombreImagen = iniciativa.getImagen();
            int idImagen = context.getResources().getIdentifier(nombreImagen, "drawable", context.getPackageName());
            dataImage.setImageResource(idImagen);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(iniciativa, getAdapterPosition());
                }
            });
        }
    }
    public interface OnItemClickListener{
        void onItemClick(Iniciativa iniciativa, int adapterPosition);
    }

}
