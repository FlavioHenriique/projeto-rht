package br.edu.ifpb.apirht.service;

import br.edu.ifpb.apirht.entity.Empresa;
import br.edu.ifpb.apirht.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository repository;

    public EmpresaService() {
    }

    public boolean salvar(Empresa empresa) {

        if (buscar(empresa.getCodigo()) == null) {
            repository.save(empresa);
            return true;
        } else {
            return false;
        }
    }

    public Empresa buscar(int codigo) {
        Optional<Empresa> e = repository.findById(codigo);
        return (e.isPresent()) ? e.get() : null;
    }
}
