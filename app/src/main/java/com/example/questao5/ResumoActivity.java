package com.example.questao5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ResumoActivity extends AppCompatActivity {

    TextView txtResumo;
    Button btnNovoPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo);

        txtResumo = findViewById(R.id.txtResumo);
        btnNovoPedido = findViewById(R.id.btnNovoPedido);

        ArrayList<String> sabores = getIntent().getStringArrayListExtra("sabores");
        String tamanho = getIntent().getStringExtra("tamanho");
        String pagamento = getIntent().getStringExtra("pagamento");

        StringBuilder resumo = new StringBuilder();
        resumo.append("Sabores: ").append(sabores != null ? String.join(", ", sabores) : "Nenhum").append("\n");
        resumo.append("Tamanho: ").append(tamanho).append("\n");
        resumo.append("Pagamento: ").append(pagamento);

        txtResumo.setText(resumo.toString());

        btnNovoPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResumoActivity.this, SelecaoPizzaActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
