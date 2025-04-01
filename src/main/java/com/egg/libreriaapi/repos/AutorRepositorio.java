package com.egg.libreriaapi.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.egg.libreriaapi.entidades.Autor;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor, String> {

}
