package br.edu.ifpb.apirht.repository;


import br.edu.ifpb.apirht.entity.Dados;
import br.edu.ifpb.apirht.entity.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface RespostaRepository extends JpaRepository<Resposta, Integer> {

    @Modifying
    @Query("SELECT new br.edu.ifpb.apirht.entity.Dados(count(r), r.estrategia) " +
            " FROM Resposta r " +
            "WHERE r.empresa.codigo = ?1 GROUP BY r.estrategia")
    List<Dados> dadosGrafico(int empresa);
}
