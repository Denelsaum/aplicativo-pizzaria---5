package com.example.questao5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SelecaoPizzaActivity extends AppCompatActivity {

    CheckBox cbCalabresa, cbMargarita, cbPortuguesa;
    Button btnProximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecao_pizza);

        cbCalabresa = findViewById(R.id.cbCalabresa);
        cbMargarita = findViewById(R.id.cbMargarita);
        cbPortuguesa = findViewById(R.id.cbPortuguesa);
        btnProximo = findViewById(R.id.btnProximo);

        btnProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> sabores = new ArrayList<>();

                if (cbCalabresa.isChecked()) sabores.add("Calabresa");
                if (cbMargarita.isChecked()) sabores.add("Margarita");
                if (cbPortuguesa.isChecked()) sabores.add("Portuguesa");

                Intent intent = new Intent(SelecaoPizzaActivity.this, TamanhoePagamentoActivity.class);
                intent.putStringArrayListExtra("sabores", sabores);
                startActivity(intent);
            }
        });
    }
}
