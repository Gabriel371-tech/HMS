package com.hospital.hms.service;

import com.hospital.hms.model.TipoSanguineo;
import com.hospital.hms.repository.TipoSanguineoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TipoSanguineoService {

    @Autowired
    private TipoSanguineoRepository tipoSanguineoRepository;

    public List<TipoSanguineo> listarTodos() {
        return tipoSanguineoRepository.findAll();
    }

    public Optional<TipoSanguineo> buscarPorId(Long id) {
        return tipoSanguineoRepository.findById(id);
    }

    public TipoSanguineo salvar(TipoSanguineo tipoSanguineo) {
        return tipoSanguineoRepository.save(tipoSanguineo);
    }

    public void excluir(Long id) {
        tipoSanguineoRepository.deleteById(id);
    }
}
