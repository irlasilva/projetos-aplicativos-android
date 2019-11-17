package br.edu.ifrs.projetoexemplomd.model;

import java.util.ArrayList;
import java.util.List;

public class Dica {

    private String id;
    private String assuntoDica;
    private String descricaoDica;

    public Dica() {}

    public Dica(String assuntoDica, String descricaoDica) {
        this.assuntoDica = assuntoDica;
        this.descricaoDica = descricaoDica;
    }

    public Dica(String id, String assuntoDica, String descricaoDica) {
        this.id = id;
        this.assuntoDica = assuntoDica;
        this.descricaoDica = descricaoDica;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAssuntoDica() {
        return assuntoDica;
    }

    public void setAssuntoDica(String assuntoDica) {
        this.assuntoDica = assuntoDica;
    }

    public String getDescricaoDica() {
        return descricaoDica;
    }

    public void setDescricaoDica(String descricaoDica) {
        descricaoDica = descricaoDica;
    }

    @Override
    public String toString() {
        return "Dica{" +
                "id='" + id + '\'' +
                "assunto='" + assuntoDica + '\'' +
                ", descricao='" + descricaoDica + '\'' +
                '}';
    }

    public static List<Dica> inicializaListaDicas(){
        List<Dica> dicas = new ArrayList<>();
        dicas.add(new Dica("Transporte", "Sempre avise alguém. Sente-se no banco de trás. Compatilhe sua localização e informe marca, cor e placa do carro."));
        dicas.add(new Dica("Encontro", "Sempre avise alguém. Sé beba líquido das garrafas abertas na hora - garrafas lacradas"));
        dicas.add(new Dica("No Trabalho", "Sempre avisem alguém"));
        dicas.add(new Dica("Reuniões", "Sempre avisem alguém"));
        dicas.add(new Dica("Quando pegarem taxi sozinha", "Sempre avisem alguém"));
        dicas.add(new Dica("Quando pegarem uber sozinha", "Sempre avisem alguém"));
        return dicas;
    }
}
