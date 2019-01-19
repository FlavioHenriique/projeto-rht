package br.edu.ifpb.apirht.entity;

import javax.persistence.*;

@Entity
public class Opcao {

    @Id
    @GeneratedValue
    private int id;
    private String texto;
    @Enumerated(EnumType.STRING)
    private Estrategia estrategia;
    @ManyToOne
    private Questao questao;

    public Opcao(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Estrategia getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(Estrategia estrategia) {
        this.estrategia = estrategia;
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }
}
