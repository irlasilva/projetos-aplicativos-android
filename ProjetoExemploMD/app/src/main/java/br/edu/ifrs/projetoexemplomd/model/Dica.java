package br.edu.ifrs.projetoexemplomd.model;

public class Dica {

    private String assuntoDica;
    private String descricaoDica;

    public Dica() {}

    public Dica(String assuntoDica) {
        this.assuntoDica = assuntoDica;
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
                "assunto='" + assuntoDica + '\'' +
                ", descricao='" + descricaoDica + '\'' +
                '}';
    }
}
