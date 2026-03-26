package com.hospital.hms.controller;

import com.hospital.hms.model.TipoSanguineo;
import com.hospital.hms.service.TipoSanguineoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tipos-sanguineos")
public class TipoSanguineoController {

    @Autowired
    private TipoSanguineoService tipoSanguineoService;

    @GetMapping
    public List<TipoSanguineo> listar() {
        return tipoSanguineoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoSanguineo> buscar(@PathVariable Long id) {
        return tipoSanguineoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TipoSanguineo salvar(@RequestBody TipoSanguineo tipoSanguineo) {
        return tipoSanguineoService.salvar(tipoSanguineo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        tipoSanguineoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
