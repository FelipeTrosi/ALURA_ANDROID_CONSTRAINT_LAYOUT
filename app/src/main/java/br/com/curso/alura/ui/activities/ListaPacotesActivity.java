package br.com.curso.alura.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import br.com.curso.alura.R;
import br.com.curso.alura.dao.PacoteDAO;
import br.com.curso.alura.model.Pacote;
import br.com.curso.alura.ui.adapter.ListaPacotesAdapter;

public class ListaPacotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);

        PacoteDAO dao = new PacoteDAO();

        List<Pacote> lista = dao.lista();

        ListView listaDePacotes = findViewById(R.id.lista_pacotes_listview);
        listaDePacotes.setAdapter(new ListaPacotesAdapter(lista, this));
    }
}
