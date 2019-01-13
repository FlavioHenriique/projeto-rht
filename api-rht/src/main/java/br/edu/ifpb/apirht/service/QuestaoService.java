package br.edu.ifpb.apirht.service;

import br.edu.ifpb.apirht.entity.Questao;
import br.edu.ifpb.apirht.repository.QuestaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestaoService {

    @Autowired
    private QuestaoRepository repository;

    public List<Questao> retornaTodas(){
        return repository.findAll();
    }

    public void inserir(Questao questao){
        repository.save(questao);
    }
}
