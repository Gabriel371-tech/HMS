package com.hospital.hms.controller;

import com.hospital.hms.model.Quarto;
import com.hospital.hms.service.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/quartos")
public class QuartoController {

    @Autowired
    private QuartoService quartoService;

    @GetMapping
    public List<Quarto> listar() {
        return quartoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quarto> buscar(@PathVariable Long id) {
        return quartoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Quarto salvar(@RequestBody Quarto quarto) {
        return quartoService.salvar(quarto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        quartoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
