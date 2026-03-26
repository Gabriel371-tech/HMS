package com.hospital.hms.service;

import com.hospital.hms.model.Leito;
import com.hospital.hms.repository.LeitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LeitoService {

    @Autowired
    private LeitoRepository leitoRepository;

    public List<Leito> listarTodos() {
        return leitoRepository.findAll();
    }

    public Optional<Leito> buscarPorId(Long id) {
        return leitoRepository.findById(id);
    }

    public Leito salvar(Leito leito) {
        return leitoRepository.save(leito);
    }

    public void excluir(Long id) {
        leitoRepository.deleteById(id);
    }
}
