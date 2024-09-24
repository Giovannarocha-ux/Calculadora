package com.example.calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculadoraCombustivel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculadora_combustivel);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void goToMainActivity(View view) {
        Intent intent = new Intent(CalculadoraCombustivel.this, MainActivity.class);
        startActivity(intent);
    }

    public void compararCombustiveis(View view) {
        double precoGasolina = Double.parseDouble(((EditText) findViewById(R.id.editTextGasolina)).getText().toString());
        double precoAlcool = Double.parseDouble(((EditText) findViewById(R.id.editTextAlcool)).getText().toString());

        double setentaPorcentoGasolina = precoGasolina * 0.7;

        int selectedId = ((RadioGroup) findViewById(R.id.radioGroupCombustivel)).getCheckedRadioButtonId();
        String resultado;

        if (selectedId == R.id.radioButtonAlcool) {
            if (precoAlcool < setentaPorcentoGasolina) {
                resultado = "Álcool é mais vantajoso.";
            } else {
                double diferenca = precoAlcool - setentaPorcentoGasolina;
                resultado = String.format("Álcool não é vantajoso. Está R$ %.2f acima dos 70%% da gasolina.", diferenca);
            }
        } else { // Gasolina
            if (precoGasolina < setentaPorcentoGasolina) {
                resultado = "Gasolina é mais vantajosa.";
            } else {
                double diferenca = precoGasolina - setentaPorcentoGasolina;
                resultado = String.format("Gasolina não é vantajosa. Está R$ %.2f acima dos 70%% da gasolina.", diferenca);
            }
        }

        TextView textViewResultadoCombustivel = findViewById(R.id.textViewResultado);
        textViewResultadoCombustivel.setText(String.format("%s\n70%% do preço da gasolina: R$ %.2f", resultado, setentaPorcentoGasolina));
    }

    public void limparCampos(View view) {
        EditText editPeso = findViewById(R.id.editTextGasolina);
        editPeso.setText("");

        EditText editAltura = findViewById(R.id.editTextAlcool);
        editAltura.setText("");

        ((RadioGroup) findViewById(R.id.radioGroupCombustivel)).clearCheck();

        TextView textViewResultadoIMC = findViewById(R.id.textViewResultado);
        textViewResultadoIMC.setText("Resultado:");
    }
}