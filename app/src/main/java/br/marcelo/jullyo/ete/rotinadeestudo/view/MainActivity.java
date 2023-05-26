package br.marcelo.jullyo.ete.rotinadeestudo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import br.marcelo.jullyo.ete.rotinadeestudo.R;
import br.marcelo.jullyo.ete.rotinadeestudo.conexao.Conexao;

public class MainActivity extends AppCompatActivity {

    Conexao conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conn = new Conexao(this);
        SQLiteDatabase db = conn.getReadableDatabase();

    }
    public void proximo (View view) {
        Intent tela = new Intent(MainActivity.this, Home.class);

        startActivity(tela);
    }
}