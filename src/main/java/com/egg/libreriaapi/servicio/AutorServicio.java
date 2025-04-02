package com.egg.libreriaapi.servicio;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.egg.libreriaapi.entidades.Autor;
import com.egg.libreriaapi.repos.AutorRepositorio;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AutorServicio {

  private AutorRepositorio autorRepositorio;

  public AutorServicio(AutorRepositorio autorRepositorio) {
    this.autorRepositorio = autorRepositorio;
  }

  @Transactional
  public void crearAutor(String nombre) {
    Autor autor = new Autor();
    autor.setNombreAutor(nombre);
    autor.setAutorActivo(true);
    autorRepositorio.save(autor);
  }

  @Transactional(readOnly = true)
  public Autor buscarAutorPorId(UUID id) {
    return autorRepositorio.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("No existe el autor solicitado"));
  }

  @Transactional(readOnly = true)
  public List<Autor> buscarTodosAutores() {
    return autorRepositorio.findAll();
  }

  @Transactional
  public void modificarAutor(UUID id, String nombre) {
    Autor autor = autorRepositorio.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("No existe el autor solicitado"));
    autor.setNombreAutor(nombre);
    autorRepositorio.save(autor);
  }

  @Transactional
  public void eliminarAutor(Autor autor) {
    autor.setAutorActivo(false);
    autorRepositorio.save(autor);
  }
}
