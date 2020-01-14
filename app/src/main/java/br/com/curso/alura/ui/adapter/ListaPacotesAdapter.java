package br.com.curso.alura.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import br.com.curso.alura.R;
import br.com.curso.alura.model.Pacote;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> listaDePacotes;
    private Context context;

    public ListaPacotesAdapter(List<Pacote> pacotes, Context context)  {
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
        return LayoutInflater.from(context).inflate(R.layout.item_pacote, parent, false);
    }
}
