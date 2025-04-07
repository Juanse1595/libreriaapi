package com.egg.libreriaapi.modelos;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EditorialDTO {
  private UUID id;
  private boolean editorialActiva;
  private String nombreEditorial;
}
