package br.marcelo.jullyo.ete.rotinadeestudo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Lista_dados extends AppCompatActivity {
    ListView listView;
    ArrayList dados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_dados);

        Intent i = getIntent();
        dados = i.getCharSequenceArrayListExtra("dados");

        listView = findViewById(R.id.list_dados);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,dados);
        listView.setAdapter(adapter);

    }
}