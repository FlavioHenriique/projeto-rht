package br.edu.ifpb.apirht.entity;

import javax.persistence.*;

@Entity
public class Resposta {

    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    private Empresa empresa;
    @Enumerated(EnumType.STRING)
    private Estrategia estrategia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Estrategia getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(Estrategia estrategia) {
        this.estrategia = estrategia;
    }
}
