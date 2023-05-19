package br.marcelo.jullyo.ete.rotinadeestudo;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Conexao extends SQLiteOpenHelper {
    private static final String DataBASE_NAME = "banco.db";
    private static final int DATABASE_VERSION = 1;


    public Conexao (Context ctx) {
        super( ctx, DataBASE_NAME,  null,
                DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        try{
            db.execSQL("CREATE TABLE planejamento ("+
                    "id INTEGER PRIMARY KEY autoincrement,"+
                    "disciplina	VARCHAR(100),"+
                    "data_hora	DATETIME,"+
                    "assunto	VARCHAR(100) );");

        } catch (SQLException ex) {
            Log.e("ERRO",ex.getMessage() );
        }

    }

    @SuppressLint("Range")
    public ArrayList<String> retornarDados(){
        String disciplina, assunto,data;
        Cursor cursor = getReadableDatabase().
                rawQuery("select * from planejamento order by data_hora asc",null);
        ArrayList<String> lista = new ArrayList<String>();


        while(cursor.moveToNext()) {
            disciplina = cursor.getString(cursor.getColumnIndex("disciplina"));
            assunto = cursor.getString(cursor.getColumnIndex("assunto"));
            data = cursor.getString(cursor.getColumnIndex("data_hora"));
            lista.add(data+"-"+disciplina+"-"+assunto);
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

            getWritableDatabase().insert("planejamento", null, valores);

        }catch ( SQLException ex){
            Log.e("ERRO",ex.getMessage());
        }

    }
    public Cursor  excluirPlanejamento (String id){
        Cursor cursor =getWritableDatabase().rawQuery("delete from planejamento wwere id= "+id,null );
        cursor.moveToFirst();
        return  cursor;
    }













    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
