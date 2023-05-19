package br.marcelo.jullyo.ete.rotinadeestudo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Lista_dados extends AppCompatActivity {
    ListView listView;
    ArrayList<String> dados;
    Conexao conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_dados);
        listView = findViewById(R.id.list_dados);

        Intent intent = getIntent();
        conn = new Conexao(this);
        SQLiteDatabase db = conn.getReadableDatabase();

        dados = conn.retornarDados();



            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, dados);
            listView.setAdapter(adapter);

    }
}