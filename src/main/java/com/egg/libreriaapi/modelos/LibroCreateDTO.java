package com.egg.libreriaapi.modelos;

import java.util.UUID;

import lombok.Data;

@Data
public class LibroCreateDTO {
  private Long isbn;// Este dato sera utilizado como idLibro
  private String titulo;
  private Integer ejemplares;
  private UUID idAutor;
  private UUID idEditorial;
  private boolean libroActivo;
}
