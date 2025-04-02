package com.egg.libreriaapi.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egg.libreriaapi.entidades.Autor;
import com.egg.libreriaapi.servicio.AutorServicio;

@RestController
@RequestMapping("/autor")
public class AutorControlador {
  // Instancio al servicio, para poder acceder a sus métodos.
  @Autowired
  private AutorServicio autorServicio;

  @PostMapping
  public ResponseEntity<Object> crearAutor(String nombre) {
    try {
      autorServicio.crearAutor(nombre);
      return ResponseEntity.status(HttpStatus.OK).body("Autor creado exitosamente");
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping
  public ResponseEntity<List<Autor>> listarAutores() {
    try {
      List<Autor> autores = autorServicio.buscarTodosAutores(); // Llama al servicio para obtener la lista de autores
      return new ResponseEntity<>(autores, HttpStatus.OK);
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}