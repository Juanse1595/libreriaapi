package com.egg.libreriaapi.entidades;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "editorial")
public class Editorial {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id_editorial")
  private UUID idEditorial;

  @Column(name = "editorial_activa", nullable = false)
  private boolean editorialActiva;

  @Column(name = "nombre_editorial", length = 255, nullable = false)
  private String nombreEditorial;
}
