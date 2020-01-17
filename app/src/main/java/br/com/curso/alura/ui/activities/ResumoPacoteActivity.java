package br.com.curso.alura.ui.activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.curso.alura.R;
import br.com.curso.alura.model.Pacote;
import br.com.curso.alura.util.DataUtil;
import br.com.curso.alura.util.DiasUtil;
import br.com.curso.alura.util.MoedaUtil;
import br.com.curso.alura.util.ResourceUtil;

import static br.com.curso.alura.ui.activities.PacoteActivityConstantes.CHAVE_PACOTE;

public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo do pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        setTitle(TITULO_APPBAR);

        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE_PACOTE)) {
            final Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);

            defineImagem(pacote);
            defineLocal(pacote);
            defineDias(pacote);
            defineValor(pacote);
            defineData(pacote);

            configuraBotao(pacote);
        }
    }

    private void configuraBotao(final Pacote pacote) {
        Button botaoRealizaPedido = findViewById(R.id.resumo_pacote_botao_realizar_pedido);
        botaoRealizaPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResumoPacoteActivity.this, PagamentoPacoteActivity.class);
                intent.putExtra(CHAVE_PACOTE, pacote);
                startActivity(intent);
            }
        });
    }

    private void defineData(Pacote pacote) {
        TextView dataHospedagem = findViewById(R.id.resumo_pacote_data);
        String dataReservada = DataUtil.periodoEmTexto(pacote.getDias());
        dataHospedagem.setText(dataReservada);
    }

    private void defineValor(Pacote pacote) {
        TextView valorFinal = findViewById(R.id.resumo_pacote_valor_final);
        String valorFormatado = MoedaUtil.formataMoedaBrasileira(pacote.getPreco());
        valorFinal.setText(valorFormatado);
    }

    private void defineDias(Pacote pacote) {
        TextView dias = findViewById(R.id.resumo_pacote_dias);
        String diasEmTexto = DiasUtil.formataDiasEmTexto(pacote.getDias());
        dias.setText(diasEmTexto);
    }

    private void defineLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_pacote_cidade);
        local.setText(pacote.getLocal());
    }

    private void defineImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumo_pacote_imagem_cidade);
        Drawable imagemDevolvida = ResourceUtil.devolveDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(imagemDevolvida);
    }
}
