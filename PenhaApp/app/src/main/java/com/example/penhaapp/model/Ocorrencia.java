package com.example.penhaapp.model;

public class Ocorrencia {
    private int _id;
    private String tipo;
    private String descricao;
    private String data;

    public Ocorrencia(){}

    public Ocorrencia(int id, String tipo, String descricao, String data) {
        this._id = id;
        this.tipo = tipo;
        this.descricao = descricao;
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }
}
