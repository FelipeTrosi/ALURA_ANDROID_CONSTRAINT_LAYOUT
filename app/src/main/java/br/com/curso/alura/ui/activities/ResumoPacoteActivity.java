package br.com.curso.alura.ui.activities;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.curso.alura.R;
import br.com.curso.alura.model.Pacote;
import br.com.curso.alura.util.DiasUtil;
import br.com.curso.alura.util.MoedaUtil;
import br.com.curso.alura.util.ResourceUtil;

public class ResumoPacoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        Pacote pacote = new Pacote("São Paulo", "sao_paulo_sp", 3, new BigDecimal(2339.99));

        defineImagem(pacote);
        defineLocal(pacote);
        defineDias(pacote);
        defineValor(pacote);
        defineData(pacote);
    }

    private void defineData(Pacote pacote) {
        TextView dataHospedagem = findViewById(R.id.resumo_pacote_data);
        Calendar dataHoje = Calendar.getInstance();
        Calendar dataFinal = Calendar.getInstance();
        dataFinal.add(Calendar.DATE, pacote.getDias());
        SimpleDateFormat formataData = new SimpleDateFormat("dd/MM");
        String dataHojeFormatada = formataData.format(dataHoje.getTime());
        String dataFinalFormatada = formataData.format(dataFinal.getTime());
        String dataReservada = dataHojeFormatada + " - " + dataFinalFormatada + " de " + dataFinal.get(Calendar.YEAR);
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
