package com.hospital.hms.service;

import com.hospital.hms.model.Ala;
import com.hospital.hms.repository.AlaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AlaService {

    @Autowired
    private AlaRepository alaRepository;

    public List<Ala> listarTodos() {
        return alaRepository.findAll();
    }

    public Optional<Ala> buscarPorId(Long id) {
        return alaRepository.findById(id);
    }

    public Ala salvar(Ala ala) {
        return alaRepository.save(ala);
    }

    public void excluir(Long id) {
        alaRepository.deleteById(id);
    }
}
