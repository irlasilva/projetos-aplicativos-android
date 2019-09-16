package br.edu.ifrs.progweb3.util;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDUtil extends SQLiteOpenHelper {

    private static final String BASE_DE_DADOS = "AGENDA";
    private static final int VERSAO = 1; //o app ajusta fazendo uma migração dos dados - esse n. de versão deve ser mudado para 2, 3 ...
    //apenas para mudanças grandes em tabelas, colunas
    //Helper inicializa o banco

    public BDUtil(Context context){
        super(context,BASE_DE_DADOS,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder criarTabela = new StringBuilder(); //StringBuilder é um string dinâmico - .append vai concatenando as strings maiores
        criarTabela.append(" CREATE TABLE TAREFA (");
        criarTabela.append(" _ID   INTEGER PRIMARY KEY AUTOINCREMENT, ");
        criarTabela.append(" NOME  TEXT    NOT NULL,");
        criarTabela.append(" DESCRICAO   TEXT    NOT NULL,");
        criarTabela.append(" DATA TEXT    NOT NULL)");
        db.execSQL(criarTabela.toString());
    }

    /*Método abaixo é executado quando troa a versão do BD*/
    //se mudou a versão ele executa esse primeiro onUpgrade e depois o onCreate
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS TAREFA");
        onCreate(db);
    }

    /*Método usado para obter a conexão com o BD*/
    public SQLiteDatabase getConexao(){
        return this.getWritableDatabase();
    }

}