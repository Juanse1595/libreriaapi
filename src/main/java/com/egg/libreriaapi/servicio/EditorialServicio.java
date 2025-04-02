package com.egg.libreriaapi.servicio;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.egg.libreriaapi.entidades.Editorial;
import com.egg.libreriaapi.repos.EditorialRepositorio;

@Service
public class EditorialServicio {
  private EditorialRepositorio editorialRepositorio;

  public EditorialServicio(EditorialRepositorio editorialRepositorio) {
    this.editorialRepositorio = editorialRepositorio;
  }

  @Transactional
  public Editorial crearEditorial(String nombre) {
    Editorial editorial = new Editorial();
    editorial.setNombreEditorial(nombre);
    editorial.setEditorialActiva(true);
    return editorialRepositorio.save(editorial);
  }
}
