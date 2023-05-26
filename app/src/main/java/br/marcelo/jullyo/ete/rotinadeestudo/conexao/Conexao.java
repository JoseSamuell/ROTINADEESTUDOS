package br.marcelo.jullyo.ete.rotinadeestudo.conexao;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

import br.marcelo.jullyo.ete.rotinadeestudo.model.Planejamento;
import br.marcelo.jullyo.ete.rotinadeestudo.R;

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



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}
