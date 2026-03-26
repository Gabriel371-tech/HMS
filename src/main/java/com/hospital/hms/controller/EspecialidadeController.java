package com.hospital.hms.controller;

import com.hospital.hms.model.Especialidade;
import com.hospital.hms.service.EspecialidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/especialidades")
public class EspecialidadeController {

    @Autowired
    private EspecialidadeService especialidadeService;

    @GetMapping
    public List<Especialidade> listar() {
        return especialidadeService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Especialidade> buscar(@PathVariable Long id) {
        return especialidadeService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Especialidade salvar(@RequestBody Especialidade especialidade) {
        return especialidadeService.salvar(especialidade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        especialidadeService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
