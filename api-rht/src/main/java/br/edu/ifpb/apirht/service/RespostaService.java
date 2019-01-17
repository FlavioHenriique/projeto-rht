package br.edu.ifpb.apirht.service;

import br.edu.ifpb.apirht.entity.Resposta;
import br.edu.ifpb.apirht.repository.EmpresaRepository;
import br.edu.ifpb.apirht.repository.QuestaoRepository;
import br.edu.ifpb.apirht.repository.RespostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespostaService {
    @Autowired
    private RespostaRepository repository;
    @Autowired
    private EmpresaRepository empresaRepository;

    public void salvarResultado(Resposta resposta){
        empresaRepository.save(resposta.getEmpresa());
        repository.save(resposta);
    }

    public List<Resposta> todas(){
        return repository.findAll();
    }
}
