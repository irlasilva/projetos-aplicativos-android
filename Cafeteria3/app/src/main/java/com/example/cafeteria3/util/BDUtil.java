package com.example.cafeteria3.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDUtil extends SQLiteOpenHelper {
    private static final String BASE_DE_DADOS = "CAFETERIA3BD";
    private static final int VERSAO = 1;

    public BDUtil(Context context){
        super(context,BASE_DE_DADOS,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder criarTabela = new StringBuilder(); //StringBuilder é um string dinâmico - .append vai concatenando as strings maiores
        criarTabela.append(" CREATE TABLE BEBIDA (");
        criarTabela.append(" _ID   INTEGER PRIMARY KEY AUTOINCREMENT, ");
        criarTabela.append(" NOME  TEXT    NOT NULL,");
        criarTabela.append(" DESCRICAO   TEXT    NOT NULL,");
        criarTabela.append(" DATA TEXT    NOT NULL)");
        db.execSQL(criarTabela.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS BEBIDA");
        onCreate(db);
    }

    /*Método usado para obter a conexão com o BD*/
    public SQLiteDatabase getConexao(){
        return this.getWritableDatabase();
    }

}
