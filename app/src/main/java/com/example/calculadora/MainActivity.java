package com.example.calculadora;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

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
    }

    public void goToCalculadoraImcActivity(View view) {
        Intent intent = new Intent(MainActivity.this, CalculadoraImc.class);
        startActivity(intent);
    }

    public void goToCalculadoraCombustivelActivity(View view) {
        Intent intent = new Intent(MainActivity.this, CalculadoraCombustivel.class);
        startActivity(intent);
    }

    public void goToApresentacao(View view) {
        Intent intent = new Intent(MainActivity.this, Apresentacao.class);
        startActivity(intent);
    }

    public void fecharApp(View view) {
        finishAffinity();
    }
}