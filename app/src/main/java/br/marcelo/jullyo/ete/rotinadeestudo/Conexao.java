package br.marcelo.jullyo.ete.rotinadeestudo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

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
                    "id int,"+
                    "dsciplina	VARCHAR,"+
                    "data_hora	DATETIME,"+
                    "assunto	VARCHAR );");

        } catch (SQLException ex) {
            Log.e("Aula",ex.getMessage() );
        }

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
