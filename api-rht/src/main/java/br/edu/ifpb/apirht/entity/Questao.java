package br.edu.ifpb.apirht.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Questao {

    @Id
    @GeneratedValue
    private int id;
    private String pergunta;
    @OneToMany
    private List<Opcao> opcoes;
    private int posicao;

    public Questao() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public List<Opcao> getOpcoes() {
        return opcoes;
    }

    public void setOpcoes(List<Opcao> opcoes) {
        this.opcoes = opcoes;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }
}
