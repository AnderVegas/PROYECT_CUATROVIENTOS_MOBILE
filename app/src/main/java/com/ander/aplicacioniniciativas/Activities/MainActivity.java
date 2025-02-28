package com.ander.aplicacioniniciativas.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ander.aplicacioniniciativas.R;

public class MainActivity extends AppCompatActivity {

    View layoutIniciativas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        layoutIniciativas = findViewById(R.id.layoutButtonIniciativas);

        layoutIniciativas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir ActivityIniciativas
                Intent intent = new Intent(MainActivity.this, IniciativasActivity.class);
                startActivity(intent);
            }
        });
    }
}