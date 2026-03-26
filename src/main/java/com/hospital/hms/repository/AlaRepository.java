package com.hospital.hms.repository;

import com.hospital.hms.model.Ala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlaRepository extends JpaRepository<Ala, Long> {
}
