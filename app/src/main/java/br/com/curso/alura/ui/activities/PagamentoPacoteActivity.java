package br.com.curso.alura.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.math.BigDecimal;

import br.com.curso.alura.R;
import br.com.curso.alura.model.Pacote;
import br.com.curso.alura.util.MoedaUtil;

public class PagamentoPacoteActivity extends AppCompatActivity {

    public static final String TITULO_APP_BAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento_pacote);

        Pacote pacote = new Pacote("São Paulo", "sao_paulo_sp", 3, new BigDecimal(2339.99));

        setTitle(TITULO_APP_BAR);

        definePreco(pacote);

        Intent intent = new Intent(this, ResumoCompraActivity.class);
        startActivity(intent);
    }

    private void definePreco(Pacote pacote) {
        TextView valor = findViewById(R.id.pagamento_pacote_valor);
        String valorFormatado = MoedaUtil.formataMoedaBrasileira(pacote.getPreco());
        valor.setText(valorFormatado);
    }
}
