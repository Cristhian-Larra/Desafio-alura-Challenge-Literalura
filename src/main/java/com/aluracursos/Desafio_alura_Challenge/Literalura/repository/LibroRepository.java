package com.aluracursos.Desafio_alura_Challenge.Literalura.repository;

import com.aluracursos.Desafio_alura_Challenge.Literalura.model.Libros;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libros, Long> {

    Optional<Libros> findByTitulo(String titulo);
    
}
