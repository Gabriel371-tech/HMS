package com.hospital.hms.controller;

import com.hospital.hms.model.Ala;
import com.hospital.hms.service.AlaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/alas")
public class AlaController {

    @Autowired
    private AlaService alaService;

    @GetMapping
    public List<Ala> listar() {
        return alaService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ala> buscar(@PathVariable Long id) {
        return alaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Ala salvar(@RequestBody Ala ala) {
        return alaService.salvar(ala);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        alaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
