package com.example.penhaapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.penhaapp.model.Ocorrencia;
import com.example.penhaapp.util.BDUtil;

import java.util.ArrayList;
import java.util.List;

public class OcorrenciaRepository {
    private BDUtil bdUtil;

    public OcorrenciaRepository(Context context){
        bdUtil =  new BDUtil(context);
    }

    public String insert(String tipo, String descricao, String data){
        ContentValues valores = new ContentValues();  //o SQLite precisa de uma area de valores
        valores.put("TIPO", tipo);
        valores.put("DESCRICAO", descricao);
        valores.put("DATA", data);
        long resultado = bdUtil.getConexao().insert("OCORRENCIA", null, valores); //getConexao para conectar com o banco
        if (resultado ==-1) {
            bdUtil.close();
            return "Erro ao inserir registro";
        }
        return "Registro Inserido com sucesso";
    }
    public Integer delete(int codigo){
        Integer linhasAfetadas = bdUtil.getConexao().delete("OCORRENCIA","_id = ?", new String[]{Integer.toString(codigo)});
        bdUtil.close();
        return linhasAfetadas;
    }

    public List<Ocorrencia> getAll(){
        List<Ocorrencia> ocorrencias = new ArrayList<>();
        // monta a consulta para listar os registros
        StringBuilder stringBuilderQuery = new StringBuilder();
        stringBuilderQuery.append("SELECT _ID, TIPO, DESCRICAO, DATA "); //terá campo 'LOCAL' posteriormente
        stringBuilderQuery.append("FROM  OCORRENCIA ");
        stringBuilderQuery.append("ORDER BY TIPO");
        //consulta os registros que estão no BD
        Cursor cursor = bdUtil.getConexao().rawQuery(stringBuilderQuery.toString(), null);
        //aponta cursos para o primeiro registro
        cursor.moveToFirst();
        Ocorrencia ocorrencia = null; //cria o objeto
        //Percorre os registros até atingir o fim da lista de registros
        while (!cursor.isAfterLast()){
            // Cria objetos do tipo tarefa
            ocorrencia =  new Ocorrencia();
            //adiciona os dados no objeto
            ocorrencia.set_id(cursor.getInt(cursor.getColumnIndex("_ID")));
            ocorrencia.setTipo(cursor.getString(cursor.getColumnIndex("TIPO")));
            ocorrencia.setDescricao(cursor.getString(cursor.getColumnIndex("DESCRICAO")));
            ocorrencia.setData(cursor.getString(cursor.getColumnIndex("DATA")));
            //adiciona o objeto na lista - adiciona na lista semelhante ao resultSet
            ocorrencias.add(ocorrencia);
            //aponta para o próximo registro
            cursor.moveToNext();
        }
        bdUtil.close(); //fechar o banco
        //retorna a lista de objetos
        return ocorrencias;
    }
    public Ocorrencia getTarefa(int codigo){
        Cursor cursor =  bdUtil.getConexao().rawQuery("SELECT * FROM OCORRENCIA WHERE _ID = "+ codigo,null);
        cursor.moveToFirst();
        Ocorrencia t = new Ocorrencia();
        t.set_id(cursor.getInt(cursor.getColumnIndex("_ID")));
        t.setTipo(cursor.getString(cursor.getColumnIndex("TIPO")));
        t.setDescricao(cursor.getString(cursor.getColumnIndex("DESCRICAO")));
        t.setData(cursor.getString(cursor.getColumnIndex("DATA")));
        bdUtil.close();
        return t;
    }

    public int update(Ocorrencia ocorrencia){
        ContentValues contentValues =  new ContentValues();
        contentValues.put("TIPO", ocorrencia.getTipo());
        contentValues.put("DESCRICAO", ocorrencia.getDescricao());
        contentValues.put("DATA", ocorrencia.getData());
        //atualiza o objeto usando a chave
        int retorno = bdUtil.getConexao().update("OCORRENCIA", contentValues, "_id = ?", new String[]{Integer.toString(ocorrencia.get_id())});
        bdUtil.close();
        return retorno;
    }
}

