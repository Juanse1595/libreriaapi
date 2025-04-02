package com.egg.libreriaapi.entidades;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "autor")
public class Autor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id_autor")
  private UUID idAutor;

  @Column(name = "autor_activo", nullable = false)
  private boolean autorActivo;

  @Column(name = "nombre_autor", nullable = false, length = 255)
  private String nombreAutor;

}
