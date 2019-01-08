package br.edu.ifpb.apirht.repository;

import br.edu.ifpb.apirht.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
}
