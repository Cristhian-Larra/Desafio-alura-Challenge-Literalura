package com.aluracursos.Desafio_alura_Challenge.Literalura.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "libros")
public class Libros {
    @Id
    private Long id;
    @Column(unique = true)
    private String titulo;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "libros_autores",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private List<Autores> autores;

    private List<String> idiomas;
    private Double numeroDeDescargas;
    public Libros() {
    }

    public Libros(DatosLibros datosLibros) {
        this.id = datosLibros.id();
        this.titulo = datosLibros.titulo();
        this.autores = datosLibros.autor().stream().map(Autores::new).collect(Collectors.toList());
        this.idiomas = datosLibros.idiomas();
        this.numeroDeDescargas = datosLibros.numeroDeDescargas();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autores> getAutores() {
        return autores;
    }

    public void setAutores(List<Autores> autores) {
        this.autores = autores;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public Double getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(Double numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }

    @Override
    public String toString() {
        String nombresAutores = autores.stream()
                .map(Autores::getNombre)
                .collect(Collectors.joining(" - "));
        String idiomas = this.idiomas.stream()
                .collect(Collectors.joining(" - "));
        return
                " -------- LIBRO -------- \n" +
                " titulo= " + titulo + "\n" +
                " autores= " + nombresAutores + "\n" +
                " idiomas= " + idiomas + "\n" +
                " numero De Descargas= " + numeroDeDescargas + "\n" +
                        "_______________________\n\n";
    }
}
