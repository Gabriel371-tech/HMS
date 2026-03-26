package com.hospital.hms.repository;

import com.hospital.hms.model.TipoSanguineo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoSanguineoRepository extends JpaRepository<TipoSanguineo, Long> {
}
