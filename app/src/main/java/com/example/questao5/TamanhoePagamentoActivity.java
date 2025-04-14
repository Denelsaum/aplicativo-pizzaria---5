package com.example.questao5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TamanhoePagamentoActivity extends AppCompatActivity {

    RadioGroup rgTamanho, rgPagamento;
    Button btnConfirmarPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tamanhoe_pagamento);

        rgTamanho = findViewById(R.id.rgTamanho);
        rgPagamento = findViewById(R.id.rgPagamento);
        btnConfirmarPedido = findViewById(R.id.btnConfirmarPedido);

        ArrayList<String> sabores = getIntent().getStringArrayListExtra("sabores");

        btnConfirmarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int tamanhoId = rgTamanho.getCheckedRadioButtonId();
                int pagamentoId = rgPagamento.getCheckedRadioButtonId();

                if (tamanhoId != -1 && pagamentoId != -1) {
                    RadioButton rbTamanho = findViewById(tamanhoId);
                    RadioButton rbPagamento = findViewById(pagamentoId);

                    String tamanho = rbTamanho.getText().toString();
                    String pagamento = rbPagamento.getText().toString();

                    Intent intent = new Intent(TamanhoePagamentoActivity.this, ResumoActivity.class);
                    intent.putStringArrayListExtra("sabores", sabores);
                    intent.putExtra("tamanho", tamanho);
                    intent.putExtra("pagamento", pagamento);
                    startActivity(intent);
                }
            }
        });
    }
}
