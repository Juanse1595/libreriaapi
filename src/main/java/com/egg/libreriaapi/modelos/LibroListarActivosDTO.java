package com.egg.libreriaapi.modelos;

import lombok.Data;

@Data
public class LibroListarActivosDTO {
  private String titulo;
  private int ejemplares;

  // Constructor needed for JPQL query
  public LibroListarActivosDTO(String titulo, int ejemplares) {
    this.titulo = titulo;
    this.ejemplares = ejemplares;
  }

  // No-args constructor
  public LibroListarActivosDTO() {
  }
}
