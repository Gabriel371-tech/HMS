package com.hospital.hms.controller;

import com.hospital.hms.model.Leito;
import com.hospital.hms.service.LeitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/leitos")
public class LeitoController {

    @Autowired
    private LeitoService leitoService;

    @GetMapping
    public List<Leito> listar() {
        return leitoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Leito> buscar(@PathVariable Long id) {
        return leitoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Leito salvar(@RequestBody Leito leito) {
        return leitoService.salvar(leito);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        leitoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
