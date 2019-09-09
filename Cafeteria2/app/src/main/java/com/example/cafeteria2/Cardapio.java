package com.example.cafeteria2;

public class Cardapio {
    private String tipo;
    private String nome;
    private float preco;
    private int idImagem;

    private Cardapio(){}

    public static final Cardapio bebidas[] = {
        new Cardapio("Café", "Latte", 5, R.drawable.img_fruit),
        new Cardapio("Café", "Capuccino", 6, R.drawable.img_french_fries),
        new Cardapio("Chocolate", "Quente", 7, R.drawable.img_ice_cream),
        new Cardapio("Chá", "Maçã", 3, R.drawable.img_noodles_food_cup),
        new Cardapio("Chá", "Preto", 4, R.drawable.img_fruit)};

    public Cardapio(String tipo, String nome, float preco, int imagem) {
        this.tipo = tipo; this.nome = nome; this.preco = preco; this.idImagem = imagem;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getIdImagem() {
        return idImagem;
    }

    public void setIdImagem(int idImagem) {
        this.idImagem = idImagem;
    }

    @Override
    public String toString() {
        return tipo + " " + nome + " - R$" + preco ;
    }
}
