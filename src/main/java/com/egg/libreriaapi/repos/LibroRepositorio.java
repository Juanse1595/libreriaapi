package com.egg.libreriaapi.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.egg.libreriaapi.entidades.Libro;
import com.egg.libreriaapi.modelos.LibroListarActivosDTO;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro, Long> {
  @Query("SELECT new com.egg.libreriaapi.modelos.LibroListarActivosDTO(l.titulo, l.ejemplares) " +
      "FROM libro l WHERE l.libroActivo = true")
  List<LibroListarActivosDTO> encontrarActivos();
}
