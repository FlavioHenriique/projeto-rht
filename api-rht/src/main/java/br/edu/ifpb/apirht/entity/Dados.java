package br.edu.ifpb.apirht.entity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class Dados{

    private Long count;
    @Enumerated(EnumType.STRING)
    private Estrategia estrategia;

    public Dados(){

    }

    public Dados(Long count){
        this.count = count;
    }

    public Dados(Estrategia estrategia){
        this.estrategia = estrategia;
    }

    public Dados(Long count, Estrategia estrategia){
        this.count = count;
        this.estrategia = estrategia;
    }

    public Estrategia getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(Estrategia estrategia) {
        this.estrategia = estrategia;
    }

    public Long getCount(){
        return count;
    }

    public void setCount(Long cont){
        this.count = cont;
    }
}
