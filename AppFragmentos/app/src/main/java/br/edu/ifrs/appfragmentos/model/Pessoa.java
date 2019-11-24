package br.edu.ifrs.appfragmentos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pessoa implements Serializable {
    private String nome;
    private String endereco;

    public Pessoa(){}
    public Pessoa(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                 ", endereco='" + endereco + '\'' +
                '}';
    }

    public static List<Pessoa> inicializaLista(){
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("Silvia",  "Rua x, 10"));
        pessoas.add(    new Pessoa("Maria", "Rua Vicente Monteggia xxxxxxxxxxxxxxxxxx yyyyyyyyyyyyyyyyyyyyy uuuuuuuuuuuuuuuuuuuuuuu, 20"));
        pessoas.add(    new Pessoa("José","Avenida Ipirange, 3030, apto 500"));
        pessoas.add(    new Pessoa("Mário", "Rua Otávio Francisco Caruso da Rocha, 40"));
        pessoas.add(     new Pessoa("Juca",  "Rua Coronel Vicente, 50, apto 230"));
        pessoas.add(    new Pessoa("Jane",  "Rua p, 60"));
        return pessoas;
    }
}
