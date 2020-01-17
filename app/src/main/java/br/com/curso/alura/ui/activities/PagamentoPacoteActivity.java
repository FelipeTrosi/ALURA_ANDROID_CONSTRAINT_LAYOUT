package br.com.curso.alura.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.com.curso.alura.R;
import br.com.curso.alura.model.Pacote;
import br.com.curso.alura.util.MoedaUtil;

import static br.com.curso.alura.ui.activities.PacoteActivityConstantes.CHAVE_PACOTE;

public class PagamentoPacoteActivity extends AppCompatActivity {

    public static final String TITULO_APP_BAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento_pacote);

        setTitle(TITULO_APP_BAR);
        carregaPacoteRecebido();

    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE_PACOTE)) {
            final Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);

            definePreco(pacote);

            configuraBotaoFinalizaCompra(pacote);
        }
    }

    private void configuraBotaoFinalizaCompra(final Pacote pacote) {
        Button botaoFinalizaCompra = findViewById(R.id.pagamento_pacote_finalizar_compra);
        botaoFinalizaCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vaiParaResumoCompra(pacote);
            }
        });
    }

    private void vaiParaResumoCompra(Pacote pacote) {
        Intent intent = new Intent(PagamentoPacoteActivity.this, ResumoCompraActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }

    private void definePreco(Pacote pacote) {
        TextView valor = findViewById(R.id.pagamento_pacote_valor);
        String valorFormatado = MoedaUtil.formataMoedaBrasileira(pacote.getPreco());
        valor.setText(valorFormatado);
    }
}
