package com.example.calculadoradeava;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText notaA1, notaA2, notaA3;
    private TextView resultado;
    private Button calcularButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializando os componentes da interface
        notaA1 = findViewById(R.id.notaA1);
        notaA2 = findViewById(R.id.notaA2);
        notaA3 = findViewById(R.id.notaA3);
        resultado = findViewById(R.id.resultado);
        calcularButton = findViewById(R.id.calcularButton);

        // Configurando o evento de clique no botão "Calcular"
        calcularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularMedia();
            }
        });
    }

    // Método para calcular a média das notas
    private void calcularMedia() {
        try {
            // Pegando as notas dos campos de texto
            double a1 = Double.parseDouble(notaA1.getText().toString());
            double a2 = Double.parseDouble(notaA2.getText().toString());
            double a3 = Double.parseDouble(notaA3.getText().toString());

            // Calculando a média
            double media = (a1 + a2 + a3) / 3;

            // Exibindo o resultado na tela
            resultado.setText("Média Final: " + String.format("%.2f", media));
        } catch (NumberFormatException e) {
            // Tratando o caso de entradas inválidas
            resultado.setText("Por favor, insira valores válidos.");
        }
    }
}
