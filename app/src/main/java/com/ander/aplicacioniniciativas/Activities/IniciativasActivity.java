package com.ander.aplicacioniniciativas.Activities;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ander.aplicacioniniciativas.Adapters.RecyclerDataAdapter;
import com.ander.aplicacioniniciativas.App.ApiClient;
import com.ander.aplicacioniniciativas.App.CutrovientosIniciativasService;
import com.ander.aplicacioniniciativas.Models.Iniciativa;
import com.ander.aplicacioniniciativas.R;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IniciativasActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerDataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciativas);
        CutrovientosIniciativasService apiService = ApiClient.getIniciativasService();
        Call<List<Iniciativa>> call = apiService.getIniciativas(false);

        recyclerView = (RecyclerView)  findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        call.enqueue(new Callback<List<Iniciativa>>() {
            @Override
            public void onResponse(Call<List<Iniciativa>> call, Response<List<Iniciativa>> response) {
                if (response.isSuccessful()) {
                    List<Iniciativa> iniciativas = response.body();

                    adapter = new RecyclerDataAdapter(iniciativas);
                    recyclerView.setAdapter(adapter);
                } else {
                    Log.e("Agenda2030CuatrovientosAPI", "Error en la respuesta: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Iniciativa>> call, Throwable t) {
                Log.e("Agenda2030CuatrovientosAPI", "Error en la llamada", t);
            }
        });
    }

}
