package com.egg.libreriaapi.servicio;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.egg.libreriaapi.entidades.Editorial;
import com.egg.libreriaapi.modelos.EditorialCreateDTO;
import com.egg.libreriaapi.modelos.EditorialDTO;
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

  @Transactional
  public void crearEditorial(EditorialCreateDTO editorialDTO) {
    Editorial nuevaEditorial = new Editorial();
    nuevaEditorial.setNombreEditorial(editorialDTO.getNombreEditorial());
    nuevaEditorial.setEditorialActiva(editorialDTO.isEditorialActiva());
    editorialRepositorio.save(nuevaEditorial);
  }

  @Transactional(readOnly = true)
  public Editorial buscarEditorialPorId(UUID id) {
    return editorialRepositorio.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("No existe el editorial solicitado"));
  }

  @Transactional(readOnly = true)
  public EditorialDTO buscarEditorialPorIdDTO(UUID id) {
    Editorial editorial = editorialRepositorio.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("No existe esa editorial"));
    return new EditorialDTO(editorial.getIdEditorial(), editorial.isEditorialActiva(), editorial.getNombreEditorial());
  }

  @Transactional(readOnly = true)
  public List<Editorial> buscarTodosEditoriales() {
    return editorialRepositorio.findAll();
  }
}
