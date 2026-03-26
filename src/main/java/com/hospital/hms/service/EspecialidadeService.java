package com.hospital.hms.service;

import com.hospital.hms.model.Especialidade;
import com.hospital.hms.repository.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadeService {

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    public List<Especialidade> listarTodos() {
        return especialidadeRepository.findAll();
    }

    public Optional<Especialidade> buscarPorId(Long id) {
        return especialidadeRepository.findById(id);
    }

    public Especialidade salvar(Especialidade especialidade) {
        return especialidadeRepository.save(especialidade);
    }

    public void excluir(Long id) {
        especialidadeRepository.deleteById(id);
    }
}
