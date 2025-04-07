package com.egg.libreriaapi.controladores;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egg.libreriaapi.entidades.Editorial;
import com.egg.libreriaapi.modelos.EditorialCreateDTO;
import com.egg.libreriaapi.modelos.EditorialDTO;
import com.egg.libreriaapi.servicio.EditorialServicio;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/editorial")
public class EditorialControlador {
  @Autowired
  private EditorialServicio editorialServicio;

  @PostMapping
  public ResponseEntity<Object> crearEditorial(@RequestBody EditorialCreateDTO editorialDTO) {
    try {
      editorialServicio.crearEditorial(editorialDTO);
      return ResponseEntity.status(HttpStatus.CREATED).body("Editorial creada exitosamente");
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping
  public ResponseEntity<List<Editorial>> listarEditoriales() {
    try {
      List<Editorial> editoriales = editorialServicio.buscarTodosEditoriales();
      return new ResponseEntity<>(editoriales, HttpStatus.OK);
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<EditorialDTO> listarEditorial(@PathVariable String id) {
    try {
      // Llamamos al servicio para obtener el DTO
      EditorialDTO editorialDTO = editorialServicio.buscarEditorialPorIdDTO(UUID.fromString(id));
      return ResponseEntity.ok(editorialDTO);
    } catch (EntityNotFoundException e) {
      // Si no se encuentra la entidad, devolvemos un 404
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body(null);
    } catch (Exception e) {
      // En caso de error general, devolvemos un 500
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }
}