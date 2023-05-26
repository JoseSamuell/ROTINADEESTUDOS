package br.marcelo.jullyo.ete.rotinadeestudo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.snackbar.Snackbar;

import br.marcelo.jullyo.ete.rotinadeestudo.adpters.AdapterPlane;
import br.marcelo.jullyo.ete.rotinadeestudo.conexao.Conexao;
import br.marcelo.jullyo.ete.rotinadeestudo.controller.PlaneController;
import br.marcelo.jullyo.ete.rotinadeestudo.model.Planejamento;
import br.marcelo.jullyo.ete.rotinadeestudo.R;

public class Lista_dados extends AppCompatActivity implements AdapterView.OnItemClickListener{
    ListView listView;

    AdapterPlane adp;
    PlaneController pc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_dados);
        listView = findViewById(R.id.list_dados);

        Intent intent = getIntent();
        pc = new PlaneController(getBaseContext());
        preencheLista();

    }

    public void preencheLista(){

        listView.setAdapter(null);

        //qtd = listItemVendas.size();

        adp = new AdapterPlane(this,pc.retornar());
        listView.setAdapter(adp);
        listView.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

        Planejamento p = adp.getItem(arg2);
        p.getDisciplina();

        Snackbar snackbar = Snackbar
                .make(listView,  p.getDisciplina(), Snackbar.LENGTH_LONG);
        snackbar.show();
    }
}