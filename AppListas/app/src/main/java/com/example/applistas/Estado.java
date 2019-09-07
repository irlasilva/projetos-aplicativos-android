package com.example.applistas;

public class Estado {
    private String nome;
    private String sigla;

    public static final Estado estados [] = {
            new Estado("Rio Grande do Sul", "RS"),
            new Estado("Santa Catarina", "SC"),
            new Estado("Paraná", "PR"),
            new Estado("Minas Gerais", "MG")};

    public Estado(){}

    public Estado(String nome, String sigla) {
        this.nome = nome; this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    public String toString() {
        return sigla + " - " + nome ;
    }
}
