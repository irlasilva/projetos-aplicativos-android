package br.edu.ifrs.projetoexemplomd.model;

import java.util.ArrayList;
import java.util.List;

public class Amigo {
    private String idAmigo;
    private String nomeAmigo;
    private String telefoneAmigo;

    public Amigo(){}

    public Amigo(String nomeAmigo, String telefoneAmigo) {
        this.nomeAmigo = nomeAmigo;
        this.telefoneAmigo = telefoneAmigo;
    }

    public String getIdAmigo() {
        return idAmigo;
    }

    public void setIdAmigo(String idAmigo) {
        this.idAmigo = idAmigo;
    }

    public String getNomeAmigo() {
        return nomeAmigo;
    }

    public void setNomeAmigo(String nomeAmigo) {
        this.nomeAmigo = nomeAmigo;
    }

    public String getTelefoneAmigo() {
        return telefoneAmigo;
    }

    public void setTelefoneAmigo(String telefoneAmigo) {
        this.telefoneAmigo = telefoneAmigo;
    }

    public static List<Amigo> inicializaListaAmigos(){
        List<Amigo> amigos = new ArrayList<>();
        amigos.add(new Amigo("Silvia", "3222-2909"));
        amigos.add(new Amigo("Maria", "3222-2908"));
        amigos.add(new Amigo("José", "3222-2907"));
        amigos.add(new Amigo("Joaquim","3222-2906"));
        amigos.add(new Amigo("Bruna","3222-2905"));
        return amigos;
    }
}
