package com.aluracursos.Desafio_alura_Challenge.Literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record Datos(
    @JsonAlias("results") List<DatosLibros> resultados
) {
}
