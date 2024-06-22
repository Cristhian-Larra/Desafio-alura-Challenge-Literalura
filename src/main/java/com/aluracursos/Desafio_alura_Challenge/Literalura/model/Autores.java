package com.aluracursos.Desafio_alura_Challenge.Literalura.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "autores")
public class Autores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String fechaDeNacimiento;
    private String fechaDeFallecimiento;
    @ManyToMany(mappedBy = "autores", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Libros> libros;
    public Autores() {
    }

    public Autores(DatosAutor datosAutor) {
        this.nombre = datosAutor.nombre();
        this.fechaDeNacimiento = datosAutor.fechaDeNacimient();
        this.fechaDeFallecimiento = datosAutor.fechaDeFallecimiento();
    }



    public List<Libros> getLibros() {
        return libros;
    }

    public void setLibros(List<Libros> libros) {
        this.libros = libros;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getFechaDeFallecimiento() {
        return fechaDeFallecimiento;
    }

    public void setFechaDeFallecimiento(String fechaDeFallecimiento) {
        this.fechaDeFallecimiento = fechaDeFallecimiento;
    }

    @Override
    public String toString() {
        return
                '\n' +
                "Autor: " + nombre + '\n' +
                "Fecha De Nacimiento: " + fechaDeNacimiento + '\n' +
                "Fecha De Fallecimiento: " + fechaDeFallecimiento + '\n'
                + "Libros: " + libros.stream().map(libros1 -> libros1.getTitulo()).collect(Collectors.toList());
    }
}
