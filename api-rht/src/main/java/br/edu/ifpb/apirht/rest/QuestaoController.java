package br.edu.ifpb.apirht.rest;

import br.edu.ifpb.apirht.entity.Questao;
import br.edu.ifpb.apirht.service.QuestaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/questoes")
@CrossOrigin(origins = "http://localhost:8100")
public class QuestaoController {

    @Autowired
    private QuestaoService service;

    @GetMapping
    public ResponseEntity<List<Questao>> todas() {
        List<Questao> questoes = service.retornaTodas();
        return (questoes.isEmpty()) ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(questoes);
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody List<Questao> questoes){
        service.inserir(questoes);
        return ResponseEntity.ok().build();
    }
}
