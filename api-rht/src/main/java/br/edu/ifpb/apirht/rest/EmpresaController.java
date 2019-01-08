package br.edu.ifpb.apirht.rest;

import br.edu.ifpb.apirht.entity.Empresa;
import br.edu.ifpb.apirht.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/empresas")
@CrossOrigin(origins = "http://localhost:8100")
public class EmpresaController {

    @Autowired
    private EmpresaService service;

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody Empresa empresa) {

        return (service.salvar(empresa)) ? ResponseEntity.ok().build() :
                ResponseEntity.status(409).build();
    }

    @GetMapping(value = "login/{codigo}")
    public ResponseEntity<Empresa> login(@PathVariable int codigo) {
        Empresa e = service.buscar(codigo);
        return (e == null) ? ResponseEntity.noContent().build() : ResponseEntity.ok(e);
    }
}
