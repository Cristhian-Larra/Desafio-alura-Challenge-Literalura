package com.aluracursos.Desafio_alura_Challenge.Literalura.service;

import com.aluracursos.Desafio_alura_Challenge.Literalura.model.Autores;
import com.aluracursos.Desafio_alura_Challenge.Literalura.model.DatosLibros;
import com.aluracursos.Desafio_alura_Challenge.Literalura.model.Libros;
import com.aluracursos.Desafio_alura_Challenge.Literalura.repository.AutoresRepository;
import com.aluracursos.Desafio_alura_Challenge.Literalura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibrosService {
    @Autowired
    private LibroRepository librosRepository;

    public void saveLibro(DatosLibros datosLibros) {
        Libros libro = new Libros(datosLibros);
        librosRepository.save(libro);
    }

    public List<Libros> findAll() {
        return librosRepository.findAll();
    }
}
