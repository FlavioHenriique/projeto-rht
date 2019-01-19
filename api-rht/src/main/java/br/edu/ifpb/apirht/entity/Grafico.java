package br.edu.ifpb.apirht.entity;

import java.util.List;

public class Grafico {

    private List<String> estrategias;
    private List<Long> dados;

    public Grafico(){

    }

    public List<String> getEstrategias() {
        return estrategias;
    }

    public void setEstrategias(List<String> estrategias) {
        this.estrategias = estrategias;
    }

    public List<Long> getDados() {
        return dados;
    }

    public void setDados(List<Long> dados) {
        this.dados = dados;
    }
}
