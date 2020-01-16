package br.com.curso.alura.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;

import br.com.curso.alura.R;
import br.com.curso.alura.model.Pacote;
import br.com.curso.alura.util.DataUtil;
import br.com.curso.alura.util.MoedaUtil;
import br.com.curso.alura.util.ResourceUtil;

public class ResumoCompraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);

        setTitle("Resumo da compra");

        Pacote pacote = new Pacote("São Paulo", "sao_paulo_sp", 3, new BigDecimal(2339.99));

        defineImagem(pacote);
        defineCidade(pacote);
        definePeriodo(pacote);
        defineValor(pacote);
    }

    private void defineValor(Pacote pacote) {
        TextView valor = findViewById(R.id.resumo_compra_valor);
        String valorFormatado = MoedaUtil.formataMoedaBrasileira(pacote.getPreco());
        valor.setText(valorFormatado);
    }

    private void definePeriodo(Pacote pacote) {
        TextView periodo = findViewById(R.id.resumo_compra_periodo);
        String periodoString = DataUtil.periodoEmTexto(pacote.getDias());
        periodo.setText(periodoString);
    }

    private void defineCidade(Pacote pacote) {
        TextView cidade = findViewById(R.id.resumo_compra_cidade);
        cidade.setText(pacote.getLocal());
    }

    private void defineImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumo_compra_imagem);
        Drawable drawable = ResourceUtil.devolveDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawable);
    }
}
