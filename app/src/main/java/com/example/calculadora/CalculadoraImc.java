package com.example.calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculadoraImc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculadora_imc);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void goToMainActivity(View view) {
        Intent intent = new Intent(CalculadoraImc.this, MainActivity.class);
        startActivity(intent);
    }

    public void realizarCalculo(View view) {
        double peso = Double.parseDouble(((EditText) findViewById(R.id.editTextGasolina)).getText().toString());
        double altura = Double.parseDouble(((EditText) findViewById(R.id.editTextAlcool)).getText().toString());

        double imc = (peso / (altura * altura)) * 10000;

        String classificacao;
        if (imc < 18.5) {
            classificacao = "Abaixo do peso";
        } else if (imc >= 18.5 && imc < 24.9) {
            classificacao = "Peso normal";
        } else if (imc >= 25 && imc < 29.9) {
            classificacao = "Sobrepeso";
        } else if (imc >= 30 && imc < 34.9) {
            classificacao = "Obesidade grau 1";
        } else if (imc >= 35 && imc < 39.9) {
            classificacao = "Obesidade grau 2";
        } else {
            classificacao = "Obesidade grau 3";
        }

        TextView textViewResultadoIMC = findViewById(R.id.textViewResultado);
        textViewResultadoIMC.setText(String.format("Resultado: %.2f\nClassificação: %s", imc, classificacao));
    }

    public void limparCampos(View view) {
        EditText editPeso = findViewById(R.id.editTextGasolina);
        editPeso.setText("");

        EditText editAltura = findViewById(R.id.editTextAlcool);
        editAltura.setText("");

        TextView textViewResultadoIMC = findViewById(R.id.textViewResultado);
        textViewResultadoIMC.setText("Resultado:");
    }
}