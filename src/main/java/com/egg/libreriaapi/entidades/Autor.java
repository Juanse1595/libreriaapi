package com.egg.libreriaapi.entidades;

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
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_autor", length = 255)
  private String idAutor;

  @Column(name = "autor_activo", nullable = false)
  private boolean autorActivo;

  @Column(name = "nombre_autor", nullable = false, length = 255)
  private String nombreAutor;

}
