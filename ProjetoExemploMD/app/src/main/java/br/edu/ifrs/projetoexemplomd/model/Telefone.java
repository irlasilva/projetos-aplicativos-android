package br.edu.ifrs.projetoexemplomd.model;

import java.util.ArrayList;
import java.util.List;

public class Telefone {
    private String id;
    private String nomeLocalTelefone;
    private String endereco;
    private String numeroTelefone;

    public Telefone(String nomeLocalTelefone, String numeroTelefone) {
        this.nomeLocalTelefone = nomeLocalTelefone;
        this.numeroTelefone = numeroTelefone;
    }

    public Telefone(String nomeLocalTelefone, String endereco, String numeroTelefone) {
        this.nomeLocalTelefone = nomeLocalTelefone;
        this.endereco = endereco;
        this.numeroTelefone = numeroTelefone;
    }

    public String getNomeLocalTelefone() {
        return nomeLocalTelefone;
    }

    public void setNomeLocalTelefone(String nomeLocalTelefone) {
        this.nomeLocalTelefone = nomeLocalTelefone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    @Override
    public String toString() {
        return "Telefone{" +
                "id='" + id + '\'' +
                "nome='" + nomeLocalTelefone + '\'' +
                "local='" + endereco + '\'' +
                ", numero='" + numeroTelefone + '\'' +
                '}';
    }

    public static List<Telefone> inicializaLista() {
        List<Telefone> telefones = new ArrayList<>();
        telefones.add(new Telefone("Delegacia da Mulher", "Porto Alegre - RS", "32882172"));
        telefones.add(new Telefone("Central de Atendimento à Mulher", "180"));
        telefones.add(new Telefone("Polícia Militar", "190"));
        telefones.add(new Telefone("Polícia Civil", "197"));
        telefones.add(new Telefone("SAMU", "192"));
        return telefones;
    }
}
