package br.com.curso.alura.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.List;

import br.com.curso.alura.util.DiasUtil;
import br.com.curso.alura.util.MoedaUtil;
import br.com.curso.alura.R;
import br.com.curso.alura.util.ResourceUtil;
import br.com.curso.alura.model.Pacote;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> listaDePacotes;
    private final Context context;

    public ListaPacotesAdapter(List<Pacote> pacotes, Context context) {
        this.listaDePacotes = pacotes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaDePacotes.size();
    }

    @Override
    public Object getItem(int position) {
        return listaDePacotes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_pacote, parent, false);

        Pacote pacote = listaDePacotes.get(position);

        defineLocal(viewCriada, pacote);
        defineImagem(viewCriada, pacote);
        defineDias(viewCriada, pacote);
        definePreco(viewCriada, pacote);

        return viewCriada;
    }

    private void definePreco(View viewCriada, Pacote pacote) {
        TextView preco = viewCriada.findViewById(R.id.item_pacote_preco);
        BigDecimal precoDoPacote = pacote.getPreco();
        String precoFormatado = MoedaUtil.formataMoedaBrasileira(precoDoPacote);

        preco.setText(precoFormatado);
    }

    private void defineDias(View viewCriada, Pacote pacote) {
        TextView dias = viewCriada.findViewById(R.id.item_pacote_dias);
        String diasEmTexto = DiasUtil.formataDiasEmTexto(pacote.getDias());
        dias.setText(diasEmTexto);
    }

    private void defineImagem(View viewCriada, Pacote pacote) {
        ImageView imagem = viewCriada.findViewById(R.id.item_pacote_imagem);
        Drawable drawableImagemDoPacote = ResourceUtil.devolveDrawable(context, pacote.getImagem());
        imagem.setImageDrawable(drawableImagemDoPacote);
    }

    private void defineLocal(View viewCriada, Pacote pacote) {
        TextView local = viewCriada.findViewById(R.id.item_pacote_local);
        local.setText(pacote.getLocal());
    }


}
