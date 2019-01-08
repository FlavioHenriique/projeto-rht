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

        if (service.salvar(empresa)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "login")
    public ResponseEntity<Empresa> login(@RequestBody Empresa empresa) {
        Empresa e = service.login(empresa);
        return (e == null) ? ResponseEntity.noContent().build() : ResponseEntity.ok(e);
    }
}
