package com.hospital.hms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tipos_sanguineos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoSanguineo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codtipo;

    private String tipo;

    private String fatorrh;
}
