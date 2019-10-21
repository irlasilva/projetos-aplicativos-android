package br.edu.ifrs.penhaapp3.model;

import java.util.Date;

public class Ocorrencia {
    private String tipo; //(assédio, perseguição, violência doméstica)
    private Date data;
    private String horario;
    private String Endereco; //Rua, lojas, transporte, trabalho, em casa (própria, amigos, familiares)
    //private recorrente; //mesmo local, mesma pessoa (buscar os relatos e adicionar recorrência)
    //Pode ser uma funcionalidade nos cards
    private String descricao;
    private String outro; //campo para escrever alguma observação

}
