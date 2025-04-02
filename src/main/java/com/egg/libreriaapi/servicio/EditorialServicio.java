package com.egg.libreriaapi.servicio;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.egg.libreriaapi.entidades.Editorial;
import com.egg.libreriaapi.repos.EditorialRepositorio;

import jakarta.persistence.EntityNotFoundException;

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

  @Transactional(readOnly = true)
  public Editorial buscarEditorialPorId(UUID id) {
    return editorialRepositorio.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("No existe el autor solicitado"));
  }

  @Transactional(readOnly = true)
  public List<Editorial> buscarTodosEditoriales() {
    return editorialRepositorio.findAll();
  }
}
