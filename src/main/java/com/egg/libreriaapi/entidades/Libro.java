package com.egg.libreriaapi.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "libro")
public class Libro {
  @Id
  @Column(name = "id_libro")
  private Long idLibro;

  @Column(nullable = false)
  private int ejemplares;

  @Column(nullable = false, name = "libro_activo")
  private boolean libroActivo;

  @Column(nullable = false, length = 255)
  private String titulo;

  @ManyToOne
  @JoinColumn(name = "id_autor")
  private Autor autor;

  @ManyToOne
  @JoinColumn(name = "id_editorial")
  private Editorial editorial;

}
