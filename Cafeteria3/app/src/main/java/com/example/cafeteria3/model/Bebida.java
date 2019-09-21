package com.example.cafeteria3.model;

public class Bebida {

    private int _id;
    private String nome;
    private String descricao;
    private String preco;

    public Bebida(){}

    public Bebida(int id, String nome, String descricao, String preco) {
        this._id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public String getPreco() {
            return preco;
        }

        public void setPreco(String preco) {
            this.preco = preco;
        }

        public int get_id() {
            return _id;
        }

        public void set_id(int _id) {
            this._id = _id;
        }
}
