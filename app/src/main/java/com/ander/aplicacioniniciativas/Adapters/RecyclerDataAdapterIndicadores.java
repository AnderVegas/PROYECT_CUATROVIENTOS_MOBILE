package com.ander.aplicacioniniciativas.Adapters;

import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ander.aplicacioniniciativas.Models.Indicador;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador4.ExplicacionIniciativas4;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador4.IndicadorExplicacionIniciativas4;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador7.IndicadorTieneRRSS7;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador7.TieneRRSS7;
import com.ander.aplicacioniniciativas.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;
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
        private BarChart chart;
        private TableLayout table;


        public RecyclerDataHolder(@NonNull View itemView) {
            super(itemView);
            textDesc = itemView.findViewById(R.id.tituloIndicador);
            chart = itemView.findViewById(R.id.chartIndicador);
            table = itemView.findViewById(R.id.tableExplicaciones);
        }

        public void asignData(Indicador indicador) {
            textDesc.setText(indicador.getDescripcion());

            if (indicador.getIdIndicador() == 4) {
                // Ocultar gráfico y mostrar tabla
                chart.setVisibility(View.GONE);
                table.setVisibility(View.VISIBLE);
                table.removeAllViews();

                if (indicador instanceof IndicadorExplicacionIniciativas4) {
                    List<ExplicacionIniciativas4> lista = ((IndicadorExplicacionIniciativas4) indicador).getExplicacionIniciativas();

                    // Cabecera
                    TableRow header = new TableRow(itemView.getContext());
                    TextView titulo1 = new TextView(itemView.getContext());
                    titulo1.setText("Nombre");
                    titulo1.setTypeface(null, Typeface.BOLD);
                    titulo1.setPadding(8, 8, 8, 8);

                    TextView titulo2 = new TextView(itemView.getContext());
                    titulo2.setText("Descripción");
                    titulo2.setTypeface(null, Typeface.BOLD);
                    titulo2.setPadding(8, 8, 8, 8);

                    header.addView(titulo1);
                    header.addView(titulo2);
                    table.addView(header);

                    for (ExplicacionIniciativas4 item : lista) {
                        TableRow row = new TableRow(itemView.getContext());
                        TextView nombre = new TextView(itemView.getContext());
                        nombre.setText(item.getNombre());
                        nombre.setPadding(8, 8, 8, 8);

                        TextView descripcion = new TextView(itemView.getContext());
                        descripcion.setText(item.getExplicacion());
                        descripcion.setPadding(8, 8, 8, 8);

                        row.addView(nombre);
                        row.addView(descripcion);
                        table.addView(row);
                    }
                }
                return;
            }

            if (indicador.getIdIndicador() == 7) {
                chart.setVisibility(View.GONE);
                table.setVisibility(View.VISIBLE);
                table.removeAllViews();

                if (indicador instanceof IndicadorTieneRRSS7) {
                    List<TieneRRSS7> lista = ((IndicadorTieneRRSS7) indicador).getTieneRRSS();

                    // Cabecera
                    TableRow header = new TableRow(itemView.getContext());

                    TextView titulo1 = new TextView(itemView.getContext());
                    titulo1.setText("Iniciativa");
                    titulo1.setTypeface(null, Typeface.BOLD);
                    titulo1.setPadding(8, 8, 8, 8);

                    TextView titulo2 = new TextView(itemView.getContext());
                    titulo2.setText("Medio de difusión");
                    titulo2.setTypeface(null, Typeface.BOLD);
                    titulo2.setPadding(8, 8, 8, 8);

                    TextView titulo3 = new TextView(itemView.getContext());
                    titulo3.setText("Enlace");
                    titulo3.setTypeface(null, Typeface.BOLD);
                    titulo3.setPadding(8, 8, 8, 8);

                    header.addView(titulo1);
                    header.addView(titulo2);
                    header.addView(titulo3);
                    table.addView(header);

                    for (TieneRRSS7 item : lista) {
                        TableRow row = new TableRow(itemView.getContext());

                        TextView nombre = new TextView(itemView.getContext());
                        nombre.setText(item.getNombreIniciativa());
                        nombre.setPadding(8, 8, 8, 8);

                        TextView medio = new TextView(itemView.getContext());
                        medio.setText(item.getRedesSociales().getNombre());
                        medio.setPadding(8, 8, 8, 8);

                        TextView enlace = new TextView(itemView.getContext());
                        enlace.setText(item.getRedesSociales().getEnlace());
                        enlace.setPadding(8, 8, 8, 8);

                        row.addView(nombre);
                        row.addView(medio);
                        row.addView(enlace);
                        table.addView(row);
                    }
                }
                return;
            }


            // Si no es el indicador 4, mostramos el gráfico como siempre
            chart.setVisibility(View.VISIBLE);
            table.setVisibility(View.GONE);

            List<BarEntry> entries = new ArrayList<>();
            List<Float> datos = indicador.getDatosGrafico();
            List<String> etiquetas = indicador.getEtiquetasEjeX();

            if (datos == null || datos.isEmpty()) {
                chart.clear();
                chart.setNoDataText("Sin datos disponibles");
                return;
            }

            // Agregamos los valores
            for (int i = 0; i < datos.size(); i++) {
                entries.add(new BarEntry(i, datos.get(i)));
            }

            // Creamos el dataset
            BarDataSet dataSet = new BarDataSet(entries, "Valores");
            dataSet.setColor(Color.parseColor("#4CAF50"));
            dataSet.setValueTextSize(12f); // Tamaño del valor encima
            dataSet.setValueTextColor(Color.BLACK); // Color del valor encima

            // Creamos los datos del gráfico
            BarData barData = new BarData(dataSet);
            barData.setBarWidth(0.9f);

            // Asignamos al gráfico
            chart.setData(barData);
            chart.setFitBars(true);
            chart.getDescription().setEnabled(false);

            // Configuramos el eje X con etiquetas personalizadas
            XAxis xAxis = chart.getXAxis();
            xAxis.setGranularity(1f);
            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
            xAxis.setDrawGridLines(false);

            // Validamos etiquetas
            if (etiquetas != null && etiquetas.size() == datos.size()) {
                xAxis.setValueFormatter(new IndexAxisValueFormatter(etiquetas));
            } else {
                // Generamos etiquetas automáticas si no hay
                List<String> autoLabels = new ArrayList<>();
                for (int i = 0; i < datos.size(); i++) {
                    autoLabels.add("Dato " + (i + 1));
                }
                xAxis.setValueFormatter(new IndexAxisValueFormatter(autoLabels));
            }

            // Opcional: Eje Y
            chart.getAxisLeft().setAxisMinimum(0f);
            chart.getAxisRight().setEnabled(false);

            // Animación y refresco
            chart.animateY(1000);
            chart.invalidate();
        }

    }
}
