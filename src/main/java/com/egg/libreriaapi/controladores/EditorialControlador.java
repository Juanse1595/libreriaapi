package com.egg.libreriaapi.controladores;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egg.libreriaapi.entidades.Editorial;
import com.egg.libreriaapi.servicio.EditorialServicio;

@RestController
@RequestMapping("/editorial")
public class EditorialControlador {
  @Autowired
  private EditorialServicio editorialServicio;

  @PostMapping
  public ResponseEntity<Object> crearEditorial(@RequestBody Map<String, Object> body) {
    try {
      String nombreEditorial = (String) body.get("nombreEditorial");
      Editorial editorialCreada = editorialServicio.crearEditorial(nombreEditorial);
      return ResponseEntity.status(HttpStatus.CREATED).body(editorialCreada);
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
}