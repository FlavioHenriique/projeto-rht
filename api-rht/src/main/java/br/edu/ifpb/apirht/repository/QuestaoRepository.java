package br.edu.ifpb.apirht.repository;

import br.edu.ifpb.apirht.entity.Questao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestaoRepository extends JpaRepository<Questao, Integer> {
}
