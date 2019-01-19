package br.edu.ifpb.apirht.service;

import br.edu.ifpb.apirht.entity.Dados;
import br.edu.ifpb.apirht.entity.Estrategia;
import br.edu.ifpb.apirht.entity.Grafico;
import br.edu.ifpb.apirht.entity.Resposta;
import br.edu.ifpb.apirht.repository.EmpresaRepository;
import br.edu.ifpb.apirht.repository.QuestaoRepository;
import br.edu.ifpb.apirht.repository.RespostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class RespostaService {
    @Autowired
    private RespostaRepository repository;
    @Autowired
    private EmpresaRepository empresaRepository;

    public void salvarResultado(Resposta resposta) {
        empresaRepository.save(resposta.getEmpresa());
        repository.save(resposta);
    }

    public List<Resposta> todas() {
        return repository.findAll();
    }

    public Grafico grafico(int empresa) {
        Collection<Dados> dados = repository.dadosGrafico(empresa);

        List<Long> array = new ArrayList<>();
        dados.forEach(d -> array.add(d.getCount()));

        List<String> estrategias = new ArrayList<>();
        dados.forEach(d-> estrategias.add(d.getEstrategia().toString()));

        Arrays.asList(Estrategia.values()).forEach(e->{
            if(!estrategias.contains(e.toString())){
                estrategias.add(e.toString());
                array.add(Long.parseLong("0"));
            }
        });

        Grafico grafico = new Grafico();
        grafico.setDados(array);
        grafico.setEstrategias(estrategias);
        return grafico;
    }
}
