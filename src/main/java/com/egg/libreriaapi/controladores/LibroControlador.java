package com.egg.libreriaapi.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egg.libreriaapi.modelos.LibroCreateDTO;
import com.egg.libreriaapi.modelos.LibroListarActivosDTO;
import com.egg.libreriaapi.servicio.LibroServicio;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/libro")
public class LibroControlador {
  @Autowired
  private LibroServicio libroServicio;

  @PostMapping
  public ResponseEntity<Object> crearLibro(@RequestBody LibroCreateDTO libroDTO) {
    try {
      System.out.println("Recibe: " + libroDTO);
      libroServicio.crearLibro(libroDTO);
      return new ResponseEntity<>(HttpStatus.CREATED);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("{\"Algun dato no es correcto o es nulo, revisar.\"}");
    }
  }

  @GetMapping("/activos")
  public ResponseEntity<List<LibroListarActivosDTO>> encontrarActivResponseEntity() {
    return new ResponseEntity<>(libroServicio.encontrarActivos(), HttpStatus.OK);
  }

}
