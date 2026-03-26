package com.hospital.hms.repository;

import com.hospital.hms.model.Leito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeitoRepository extends JpaRepository<Leito, Long> {
}
