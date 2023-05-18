package br.marcelo.jullyo.ete.rotinadeestudo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

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
        Intent tela = new Intent(MainActivity.this,Home.class);

        startActivity(tela);
    }
}