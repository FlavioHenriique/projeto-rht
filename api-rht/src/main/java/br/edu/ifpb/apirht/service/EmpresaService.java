package br.edu.ifpb.apirht.service;

import br.edu.ifpb.apirht.entity.Empresa;
import br.edu.ifpb.apirht.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository repository;

    public EmpresaService(){}

    public boolean salvar(Empresa empresa){

        if(repository.findById(empresa.getCodigo()).get() == null){
            repository.save(empresa);
            return true;
        }else{
            return false;
        }
    }

    public Empresa login(Empresa empresa){
        return repository.findById(empresa.getCodigo()).get();
    }
}
