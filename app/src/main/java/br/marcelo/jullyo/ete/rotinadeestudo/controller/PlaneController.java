package br.marcelo.jullyo.ete.rotinadeestudo.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import br.marcelo.jullyo.ete.rotinadeestudo.conexao.Conexao;
import br.marcelo.jullyo.ete.rotinadeestudo.model.Planejamento;

public class PlaneController {
    private SQLiteDatabase db;
    private Conexao conexao;

    public PlaneController(Context context){
        conexao = new Conexao(context);
    }

    public ArrayList<Planejamento> retornar(){

        Cursor cursor = conexao.getReadableDatabase().
                rawQuery("select * from planejamento order by data_hora asc",null);
        ArrayList<Planejamento> lista = new ArrayList<Planejamento>();


        while(cursor.moveToNext()) {

            Planejamento p = new Planejamento();
            p.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
            p.setDisciplina(cursor.getString(cursor.getColumnIndexOrThrow("disciplina")));
            p.setAssunto(cursor.getString(cursor.getColumnIndexOrThrow("assunto")));
            p.setData_hora(cursor.getString(cursor.getColumnIndexOrThrow("data_hora")));

            lista.add(p);
        }
        cursor.close();
        return lista;
    }

    public void inserirDados(Planejamento planejamento){
        try {
            ContentValues valores = new ContentValues();
            valores.put("disciplina", planejamento.getDisciplina());
            valores.put("data_hora", planejamento.getData_hora());
            valores.put("assunto", planejamento.getAssunto());

            conexao.getWritableDatabase().insert("planejamento", null, valores);

        }catch ( SQLException ex){
            Log.e("ERRO",ex.getMessage());
        }

    }
    public Cursor  excluirPlanejamento (String id){
        Cursor cursor = conexao.getWritableDatabase().rawQuery("delete from planejamento wwere id= "+id,null );
        cursor.moveToFirst();
        return  cursor;
    }

}
