package com.ander.aplicacioniniciativas.Adapters;

import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ander.aplicacioniniciativas.Models.Indicador;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador3.IndicadorCiclosModulosIniciativas3;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador3.ModelosNecesarios.CicloConModulos3;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador3.ModelosNecesarios.IniciativaConCiclos3;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador3.ModelosNecesarios.Modulo3;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador4.ExplicacionIniciativas4;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador4.IndicadorExplicacionIniciativas4;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador5.IndicadorOdsTrabajadosYSusMetas5;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador5.ModelosNecesarios.IniciativaConOds5;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador5.ModelosNecesarios.Meta5;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador5.ModelosNecesarios.OdsConMetas5;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador5.ModelosNecesarios.Triple;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador7.IndicadorTieneRRSS7;
import com.ander.aplicacioniniciativas.Models.Indicadores.Indicador7.TieneRRSS7;
import com.ander.aplicacioniniciativas.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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
        private PieChart pieChart;
        private TextView textOdsSeleccionado;
        private ListView listCursos;
        private ListView listModulos;
        private Set<String> ciclosExpandidos = new HashSet<>();
        private LineChart lineChart;


        public RecyclerDataHolder(@NonNull View itemView) {
            super(itemView);
            textDesc = itemView.findViewById(R.id.tituloIndicador);
            chart = itemView.findViewById(R.id.chartIndicador);
            table = itemView.findViewById(R.id.tableExplicaciones);
            pieChart = itemView.findViewById(R.id.pieChartIndicador);
            textOdsSeleccionado = itemView.findViewById(R.id.textOdsSeleccionado);
            listCursos = itemView.findViewById(R.id.listCursos);
            listModulos = itemView.findViewById(R.id.listModulos);
            lineChart = itemView.findViewById(R.id.lineChartIndicador);

        }

        public void asignData(Indicador indicador) {
            textDesc.setText(indicador.getDescripcion());

            pieChart.setVisibility(View.GONE);
            textOdsSeleccionado.setVisibility(View.GONE);

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



            if (indicador.getIdIndicador() == 5) {
                chart.setVisibility(View.GONE);
                table.setVisibility(View.GONE);
                pieChart.setVisibility(View.VISIBLE);
                textOdsSeleccionado.setVisibility(View.VISIBLE);
                pieChart.clear();

                if (indicador instanceof IndicadorOdsTrabajadosYSusMetas5) {
                    List<IniciativaConOds5> iniciativas = ((IndicadorOdsTrabajadosYSusMetas5) indicador).getIniciativas();

                    List<PieEntry> entries = new ArrayList<>();
                    List<Triple> metaInfoList = new ArrayList<>();

                    for (IniciativaConOds5 iniciativa : iniciativas) {
                        for (OdsConMetas5 ods : iniciativa.getOds()) {
                            for (Meta5 meta : ods.getMetas()) {
                                entries.add(new PieEntry(1f, meta.getNombreMeta()));
                                metaInfoList.add(new Triple(iniciativa.getNombreIniciativa(), ods.getNombreOds(), meta.getNombreMeta()));
                            }
                        }
                    }

                    PieDataSet dataSet = new PieDataSet(entries, "Metas trabajadas");
                    dataSet.setSliceSpace(3f);
                    dataSet.setValueTextSize(12f);

                    List<Integer> colors = new ArrayList<>();
                    for (int i = 0; i < entries.size(); i++) {
                        colors.add(Color.rgb((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255)));
                    }
                    dataSet.setColors(colors);

                    PieData pieData = new PieData(dataSet);
                    pieChart.setData(pieData);
                    pieChart.getDescription().setEnabled(false);
                    pieChart.setDrawEntryLabels(true);
                    pieChart.setUsePercentValues(false);
                    pieChart.setRotationEnabled(true);
                    pieChart.setHighlightPerTapEnabled(true);
                    pieChart.invalidate();

                    pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
                        @Override
                        public void onValueSelected(Entry e, Highlight h) {
                            int index = pieChart.getData().getDataSetForEntry(e).getEntryIndex((PieEntry) e);
                            Triple triple = metaInfoList.get(index);
                            String info = "📌 *Iniciativa:* " + triple.iniciativa +
                                    "\n🌍 *ODS:* " + triple.ods +
                                    "\n📝 *Meta:* " + triple.meta;
                            textOdsSeleccionado.setText(info);
                        }

                        @Override
                        public void onNothingSelected() {
                            textOdsSeleccionado.setText("Selecciona una meta");
                        }
                    });
                }
                return;
            }

            if (indicador.getIdIndicador() == 3) {
                chart.setVisibility(View.GONE);
                table.setVisibility(View.GONE);
                pieChart.setVisibility(View.VISIBLE);
                textOdsSeleccionado.setVisibility(View.VISIBLE);
                pieChart.clear();

                if (indicador instanceof IndicadorCiclosModulosIniciativas3) {
                    List<IniciativaConCiclos3> iniciativas = ((IndicadorCiclosModulosIniciativas3) indicador).getIniciativaConCiclos();

                    List<PieEntry> entries = new ArrayList<>();
                    for (IniciativaConCiclos3 iniciativa : iniciativas) {
                        entries.add(new PieEntry(1f, iniciativa.getNombreIniciativa()));
                    }

                    PieDataSet dataSet = new PieDataSet(entries, "Iniciativas");
                    dataSet.setSliceSpace(2f);
                    dataSet.setValueTextSize(12f);

                    List<Integer> colors = new ArrayList<>();
                    for (int i = 0; i < entries.size(); i++) {
                        colors.add(Color.rgb((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255)));
                    }
                    dataSet.setColors(colors);

                    PieData pieData = new PieData(dataSet);
                    pieChart.setData(pieData);
                    pieChart.getDescription().setEnabled(false);
                    pieChart.setDrawEntryLabels(true);
                    pieChart.setUsePercentValues(false);
                    pieChart.setRotationEnabled(true);
                    pieChart.setHighlightPerTapEnabled(true);
                    pieChart.invalidate();

                    textOdsSeleccionado.setText("Selecciona una iniciativa");

                    pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
                        @Override
                        public void onValueSelected(Entry e, Highlight h) {
                            PieEntry entry = (PieEntry) e;
                            String nombreIniciativa = entry.getLabel();

                            // Busca la iniciativa seleccionada
                            for (IniciativaConCiclos3 iniciativa : iniciativas) {
                                if (iniciativa.getNombreIniciativa().equals(nombreIniciativa)) {
                                    mostrarCiclos(iniciativa);
                                    break;
                                }
                            }
                        }

                        @Override
                        public void onNothingSelected() {
                            table.removeAllViews();
                            table.setVisibility(View.GONE);
                            textOdsSeleccionado.setText("Selecciona una iniciativa");
                        }
                    });
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

            if (indicador.getIdIndicador() == 1) {
                chart.setVisibility(View.GONE);
                pieChart.setVisibility(View.GONE);
                table.setVisibility(View.GONE);

                LineChart lineChart = itemView.findViewById(R.id.lineChartIndicador);
                lineChart.setVisibility(View.VISIBLE);
                lineChart.clear();

                List<Float> datos = indicador.getDatosGrafico();
                List<String> etiquetas = indicador.getEtiquetasEjeX();

                if (datos == null || datos.isEmpty()) {
                    lineChart.setNoDataText("Sin datos disponibles");
                    return;
                }

                List<Entry> entries = new ArrayList<>();
                for (int i = 0; i < datos.size(); i++) {
                    entries.add(new Entry(i, datos.get(i)));
                }

                LineDataSet dataSet = new LineDataSet(entries, "Valores");
                dataSet.setColor(Color.BLUE);
                dataSet.setValueTextColor(Color.BLACK);
                dataSet.setLineWidth(2f);
                dataSet.setCircleRadius(4f);
                dataSet.setCircleColor(Color.RED);

                LineData lineData = new LineData(dataSet);
                lineChart.setData(lineData);

                XAxis xAxis = lineChart.getXAxis();
                xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
                xAxis.setGranularity(1f);
                xAxis.setDrawGridLines(false);
                if (etiquetas != null && etiquetas.size() == datos.size()) {
                    xAxis.setValueFormatter(new IndexAxisValueFormatter(etiquetas));
                }

                lineChart.getAxisRight().setEnabled(false);
                lineChart.getDescription().setEnabled(false);
                lineChart.animateX(1000);
                lineChart.invalidate();

                return;
            }


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

            for (int i = 0; i < datos.size(); i++) {
                entries.add(new BarEntry(i, datos.get(i)));
            }

            BarDataSet dataSet = new BarDataSet(entries, "Valores");
            dataSet.setColor(Color.parseColor("#4CAF50"));
            dataSet.setValueTextSize(12f); // Tamaño del valor encima
            dataSet.setValueTextColor(Color.BLACK); // Color del valor encima

            BarData barData = new BarData(dataSet);
            barData.setBarWidth(0.9f);

            chart.setData(barData);
            chart.setFitBars(true);
            chart.getDescription().setEnabled(false);

            // Configuramos el eje X con etiquetas personalizadas
            XAxis xAxis = chart.getXAxis();
            xAxis.setGranularity(1f);
            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
            xAxis.setDrawGridLines(false);

            if (etiquetas != null && etiquetas.size() == datos.size()) {
                xAxis.setValueFormatter(new IndexAxisValueFormatter(etiquetas));
            } else {
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

        private void mostrarCiclos(IniciativaConCiclos3 iniciativa) {
            table.setVisibility(View.VISIBLE);
            table.removeAllViews();
            textOdsSeleccionado.setText("Iniciativa seleccionada: " + iniciativa.getNombreIniciativa());

            TableRow header = new TableRow(itemView.getContext());
            TextView titulo = new TextView(itemView.getContext());
            titulo.setText("Curso");
            titulo.setTypeface(null, Typeface.BOLD);
            titulo.setPadding(8, 8, 8, 8);
            header.addView(titulo);
            table.addView(header);

            for (CicloConModulos3 ciclo : iniciativa.getCiclos()) {
                TableRow row = new TableRow(itemView.getContext());
                TextView nombreCiclo = new TextView(itemView.getContext());
                nombreCiclo.setText(ciclo.getNombreCiclo());
                nombreCiclo.setPadding(8, 8, 8, 8);
                row.addView(nombreCiclo);
                table.addView(row);

                row.setOnClickListener(v -> {
                    String cicloKey = ciclo.getNombreCiclo();

                    if (ciclosExpandidos.contains(cicloKey)) {
                        // Colapsamos
                        ocultarModulos(ciclo);
                        ciclosExpandidos.remove(cicloKey);
                    } else {
                        // Mostramos
                        mostrarModulos(ciclo, table.indexOfChild(row));
                        ciclosExpandidos.add(cicloKey);
                    }
                });
            }
        }

        private void mostrarModulos(CicloConModulos3 ciclo, int index) {
            int insertAt = index + 1; // Insertar justo debajo del ciclo

            TableRow row = new TableRow(itemView.getContext());
            TextView modTitle = new TextView(itemView.getContext());
            modTitle.setText("Módulos de " + ciclo.getNombreCiclo());
            modTitle.setTypeface(null, Typeface.ITALIC);
            modTitle.setPadding(8, 8, 8, 8);
            row.setTag("MODULOS_" + ciclo.getNombreCiclo());
            row.addView(modTitle);
            table.addView(row, insertAt++);

            for (Modulo3 mod : ciclo.getModulos()) {
                TableRow modRow = new TableRow(itemView.getContext());
                TextView nombreModulo = new TextView(itemView.getContext());
                nombreModulo.setText("• " + mod.getNombreModulo());
                nombreModulo.setPadding(32, 4, 4, 4);
                modRow.setTag("MODULOS_" + ciclo.getNombreCiclo());

                modRow.addView(nombreModulo);
                table.addView(modRow, insertAt++);
            }
        }


        private void ocultarModulos(CicloConModulos3 ciclo) {
            String tag = "MODULOS_" + ciclo.getNombreCiclo();

            for (int i = table.getChildCount() - 1; i >= 0; i--) {
                View child = table.getChildAt(i);
                if (tag.equals(child.getTag())) {
                    table.removeViewAt(i);
                }
            }
        }
    }
}
