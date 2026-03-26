package com.hospital.hms.service;

import com.hospital.hms.model.Quarto;
import com.hospital.hms.repository.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class QuartoService {

    @Autowired
    private QuartoRepository quartoRepository;

    public List<Quarto> listarTodos() {
        return quartoRepository.findAll();
    }

    public Optional<Quarto> buscarPorId(Long id) {
        return quartoRepository.findById(id);
    }

    public Quarto salvar(Quarto quarto) {
        return quartoRepository.save(quarto);
    }

    public void excluir(Long id) {
        quartoRepository.deleteById(id);
    }
}
