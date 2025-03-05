package com.ander.aplicacioniniciativas.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ander.aplicacioniniciativas.Models.Iniciativa;
import com.ander.aplicacioniniciativas.R;

import io.realm.RealmResults;

public class RecyclerDataAdapter extends RecyclerView.Adapter<RecyclerDataAdapter.RecyclerDataHolder>{

    View view;
    private RealmResults<Iniciativa> listData;
    private OnItemClickListener itemListener;

    public RecyclerDataAdapter(RealmResults<Iniciativa> listData){
        this.listData = listData;
    }

    public RecyclerDataAdapter(RealmResults<Iniciativa> listData, OnItemClickListener listener){
        this.listData = listData;
        this.itemListener = listener;
    }

    @NonNull
    @Override
    public RecyclerDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.iniciativa_item,parent,false);
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
        TextView dataTextTitulo;
        TextView dataTextDescripcion;
        ImageView dataImage;

        public RecyclerDataHolder(@NonNull View itemView) {
            super(itemView);
            dataTextTitulo = itemView.findViewById(R.id.nombreIniciativa);
            dataTextDescripcion = itemView.findViewById(R.id.descIniciativa);
            dataImage = itemView.findViewById(R.id.imagenIniciativa);
        }

        public void asignData(Iniciativa iniciativa, final OnItemClickListener onItemClickListener) {
            dataTextTitulo.setText(iniciativa.getNombre());
            dataTextDescripcion.setText(iniciativa.getProducto_final());
            dataImage.setImageResource(iniciativa.getImagen());

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
