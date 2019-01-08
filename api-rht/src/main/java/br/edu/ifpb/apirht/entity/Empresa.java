package br.edu.ifpb.apirht.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Empresa {

    @Id
    private int codigo;
    private String nome;

    public Empresa(){}

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
