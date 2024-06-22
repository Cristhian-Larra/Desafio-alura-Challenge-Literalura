package com.aluracursos.Desafio_alura_Challenge.Literalura.repository;

import com.aluracursos.Desafio_alura_Challenge.Literalura.model.Autores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AutoresRepository extends JpaRepository<Autores, Long> {
    Optional<Autores> findByNombre(String nombre);
}
