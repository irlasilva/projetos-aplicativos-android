package com.example.cafeteria3.dao;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.cafeteria3.util.BDUtil;

public class BebidaRepository {
    private BDUtil bdUtil;

    public BebidaRepository(Context context){
        bdUtil =  new BDUtil(context);
    }

    public String insert() {
        ContentValues valores = new ContentValues();  //o SQLite precisa de uma area de valores
        valores.put("NOME", nome);
        valores.put("DESCRICAO", descricao);
        valores.put("PRECO", preco);
        long resultado = bdUtil.getConexao().insert("BEBIDA", null, valores); //getConexao para conectar com o banco
        if (resultado ==-1) {
            bdUtil.close();
            return "ERRO ao Salvar Registro";
        }
        return "Registro Salvo";
    }

    public Integer delete(int codigo) {
        Integer linhasAfetadas = bdUtil.getConexao().delete("BEBIDA","_id = ?", new String[]{Integer.toString(codigo)});
        bdUtil.close();
        return linhasAfetadas;
    }

    public List<Bebida> getAll() {
        List<Bebida> bebidas = new ArrayList<>();

        //monta a consulta para listar as bebidas
    StringBuilder stringBuilderQuery = new StringBuilder();
        stringBuilderQuery.append("SELECT _ID, NOME, DESCRICAO, PRECO");
        stringBuilderQuery.append("FROM BEBIDA");
        stringBuilderQuery.append("ORDER BY NOME");

        Cursor cursor = bdUtil.getConexao().rawQuery(stringBuilderQuery.toString(), null); //consulta os registro do banco
        cursor.moveToFirst();//aponta o cursor para o primeiro registro
        Bebida bebida = null; //cria o objeto para fazer o teste futuramente e saber que realmente obteve os registros do banco

        //while para percorrer os registros até o fim da lista
        while (!cursor.isAfterLast()) {
            //cria o objeto do tipo Bebida
            bebida = new Bebida();
            //adiciona os dados no objeto
            bebida.set_id(cursor.getInt(cursor.getColumnIndex("_ID")));
            bebida.setNome(cursor.getString(cursor.getColumnIndex("NOME")));
            bebida.setDescricao(cursor.getString(cursor.getColumnIndex("DESCRICAO")));
            bebida.setPreco(cursor.getString(cursor.getColumnIndex("PRECO")));
            //adiciona o objeto na lista
            bebidas.add(bebida);
            //aponta para o próximo registro
            cursor.moveToNext();
        }
        //fechar o banco para evitar erros
        bdUtil.close();
        //retorna lista de objetos
        return bebidas;
    }

    public Bebida getBebida(int codigo) {
        Cursor cursor = bdUtil.getConexao().rawQuery("SELECT * FROM BEBIDA _ID = "+ codigo, null);
        cursor.moveToFirst();
        Bebida t = new Bebida();
        t.set_id(cursor.getInt(cursor.getColumnIndex("_ID")));
        t.setNome(cursor.getString(cursor.getColumnIndex("NOME")));
        t.setDescricao(cursor.getString(cursor.getColumnIndex("DESCRICAO")));
        t.setPreco(cursor.getString(cursor.getColumnIndex("PRECO")));
        bdUtil.close();
        return bebida;
    }

    public int update(Bebida bebida) {
//parei aqui *************************************************************************!!!!!!!!
    return registroUpdate;
    }
}

