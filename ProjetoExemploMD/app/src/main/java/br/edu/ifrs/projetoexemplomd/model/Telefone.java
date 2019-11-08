package br.edu.ifrs.projetoexemplomd.model;

import java.util.ArrayList;
import java.util.List;

public class Telefone {
    private String nomeLocalTelefone;
    private String endereco;
    private int dddTelefone;
    private int numeroTelefone;

    public Telefone(String nomeLocalTelefone, int numeroTelefone) {
        this.nomeLocalTelefone = nomeLocalTelefone;
        this.numeroTelefone = numeroTelefone;
    }

    public Telefone(String nomeLocalTelefone, String endereco, int dddTelefone, int numeroTelefone) {
        this.nomeLocalTelefone = nomeLocalTelefone;
        this.endereco = endereco;
        this.dddTelefone = dddTelefone;
        this.numeroTelefone = numeroTelefone;
    }

    public String getNomeLocalTelefone() {
        return nomeLocalTelefone;
    }

    public void setNomeLocalTelefone(String nomeLocalTelefone) {
        this.nomeLocalTelefone = nomeLocalTelefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getDddTelefone() {
        return dddTelefone;
    }

    public void setDddTelefone(int dddTelefone) {
        this.dddTelefone = dddTelefone;
    }

    public int getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(int numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }
    @Override
    public String toString() {
        return "Telefone{" +
                "nome='" + nomeLocalTelefone + '\'' +
                "local='" + endereco + '\'' +
                ", ddd='" + dddTelefone + '\'' +
                ", numero='" + numeroTelefone + '\'' +
                '}';
    }

    public static List<Telefone> inicializaLista(){
        List<Telefone> telefones = new ArrayList<>();
        telefones.add(new Telefone("Delegacia da Mulher", "Porto Alegre - RS", 51, 32882172 ));
        telefones.add(    new Telefone("Central de Atendimento à Mulher", 180));
        telefones.add(    new Telefone("Polícia Militar", 190));
        telefones.add(    new Telefone("Polícia Civil", 197));
        telefones.add(    new Telefone("SAMU", 192));
        return telefones;
    }
}
