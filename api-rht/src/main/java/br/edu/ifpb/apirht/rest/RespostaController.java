package br.edu.ifpb.apirht.rest;

import br.edu.ifpb.apirht.entity.Grafico;
import br.edu.ifpb.apirht.entity.Resposta;
import br.edu.ifpb.apirht.service.RespostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/respostas")
@CrossOrigin(origins = "http://localhost:8100")
public class RespostaController {

    @Autowired
    private RespostaService service;
    
    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody Resposta resposta) {
        service.salvarResultado(resposta);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Resposta>> todas(@PathVariable("empresa") int empresa) {
        List<Resposta> respostas = service.todas();
        return (respostas.isEmpty()) ? ResponseEntity.noContent().build() : ResponseEntity.ok(respostas);
    }

    @GetMapping(value = "/grafico/{empresa}")
    public ResponseEntity<Grafico> grafico(@PathVariable int empresa) {
        return ResponseEntity.ok(service.grafico(empresa));
    }
}
