package com.aluracursos.Desafio_alura_Challenge.Literalura.service;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
