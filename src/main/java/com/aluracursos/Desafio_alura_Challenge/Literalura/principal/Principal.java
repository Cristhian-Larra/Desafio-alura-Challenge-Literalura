package com.aluracursos.Desafio_alura_Challenge.Literalura.principal;

import com.aluracursos.Desafio_alura_Challenge.Literalura.model.*;
import com.aluracursos.Desafio_alura_Challenge.Literalura.repository.AutoresRepository;
import com.aluracursos.Desafio_alura_Challenge.Literalura.repository.LibroRepository;
import com.aluracursos.Desafio_alura_Challenge.Literalura.service.ConsumoAPI;
import com.aluracursos.Desafio_alura_Challenge.Literalura.service.ConvierteDatos;

import java.util.*;
import java.util.stream.Collectors;


public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private final String URL_BASE = "https://gutendex.com/books/";
    private LibroRepository libroRepositorio;
    private AutoresRepository autoresRepositorio;

    public Principal(LibroRepository libroRepository, AutoresRepository autoresRepository) {
        this.libroRepositorio = libroRepository;
        this.autoresRepositorio = autoresRepository;
    }

    public void mostrarMenu(){
        var op = -1;
        while(op != 0){
            var menu = '\n' + """
                    
                1 - Buscar libro por Título
                2 - Listar todos los libros registrados
                3 - Listar Autores registrados
                4 - Listar autores vivos en determinado año
                5 - Listra libros por idioma
                6 - Generar estadísticas de descargas
                7 - Top 10 libros más descargados
                8 - Buscar autor por nombre
                0 - Salir
                """;
            System.out.println(menu);
            op = teclado.nextInt();
            teclado.nextLine();
            switch (op){
                case 1:
                    buscarLibroPorTitulo();
                    break;
                case 2:
                    listarLibros();
                    break;
                case 3:
                    listarAutores();
                    break;
                case 4:
                    listarAutoresVivos();
                    break;
                case 5:
                    listarLibrosPorIdioma();
                    break;
                case 6:
                    estadisticasDescargas();
                    break;
                case 7:
                    top10LibrosMasDescargados();
                    break;
                case 8:
                    buscarAutorPorNombre();
                    break;
                case 0:
                    System.out.println("Hasta luego");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }

    }
    private Datos getDatosLibro(){
        System.out.println("Escriba el título del libro que desea buscar: ");
        var titulo = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + "?search=" + titulo.replace(" ", "+"));
        Datos datos = conversor.obtenerDatos(json, Datos.class);
        return datos;
    }
    private void buscarLibroPorTitulo() {
        Datos datos = getDatosLibro();
        if (!datos.resultados().isEmpty() && datos != null) {
            DatosLibros datosLibros = datos.resultados().get(0);
            Libros libro = new Libros(datosLibros);
            Optional<Libros> libroOptional = libroRepositorio.findByTitulo(libro.getTitulo());
            if (libroOptional.isPresent()) {
                System.out.println("El libro ya está registrado");
            } else {
                if (!datosLibros.autor().isEmpty()) {
                    List<Autores> autoresParaGuardar = new ArrayList<>();
                    for (DatosAutor datosAutor : datosLibros.autor()) {
                        Autores autor = new Autores(datosAutor);
                        Optional<Autores> autorOptional = autoresRepositorio.findByNombre(autor.getNombre());

                        if (autorOptional.isPresent()) {
                            autoresParaGuardar.add(autorOptional.get());
                        } else {
                            Autores autorGuardado = autoresRepositorio.save(autor);
                            autoresParaGuardar.add(autorGuardado);
                        }
                    }
                    libro.setAutores(autoresParaGuardar);
                    libroRepositorio.save(libro);
                    System.out.println(libro);
                } else {
                    System.out.println("No se encontró el autor");
                }
            }
        } else {
            System.out.println("No se encontró el libro");
        }
    }
    private void listarLibros(){
        List<Libros> libros = libroRepositorio.findAll();
        libros.forEach(System.out::println);
    }
    private void listarAutores(){
        List<Autores> autores = autoresRepositorio.findAll();
        autores.forEach(System.out::println);
    }
    private void listarAutoresVivos(){
        System.out.println("Escriba el año: ");
        var anio = teclado.nextInt();
        teclado.nextLine();
        List<Autores> autores = autoresRepositorio.findAll();
        autores.forEach(autor -> {
            if(anio <= Integer.parseInt(autor.getFechaDeFallecimiento()) &&
                    anio >= Integer.parseInt(autor.getFechaDeNacimiento())){
                System.out.println(autor);
            }
        });
    }
    private void listarLibrosPorIdioma(){
        System.out.println("Ingrese el idioma para buscar los libros: ");
        var menu = """
                en - Inglés
                es - Español
                fr - Francés
                pt - Portugués
                """;
        System.out.println(menu);
        var idioma = teclado.nextLine();
        List<Libros> libros = libroRepositorio.findAll();
        libros.forEach(libro -> {
            if(libro.getIdiomas().contains(idioma)){
                System.out.println(libro);
            }
        });
    }
    private void estadisticasDescargas(){
        List<Libros> libros = libroRepositorio.findAll();
        DoubleSummaryStatistics estadisticas = libros.stream()
                .filter(libro -> libro.getNumeroDeDescargas() != null)
                .collect(Collectors.summarizingDouble(Libros::getNumeroDeDescargas));
        System.out.println("Estadísticas de descargas: ");
        System.out.println("Número de libros: " + estadisticas.getCount());
        System.out.println("Suma de descargas: " + estadisticas.getSum());
        System.out.println("Promedio de descargas: " + estadisticas.getAverage());
        System.out.println("Máximo de descargas: " + estadisticas.getMax());
        System.out.println("Mínimo de descargas: " + estadisticas.getMin());
    }
    private void top10LibrosMasDescargados(){
        List<Libros> libros = libroRepositorio.findAll();
        libros.sort(Comparator.comparing(Libros::getNumeroDeDescargas).reversed());
        libros.stream()
                .limit(10)
                .forEach(System.out::println);
    }
    void buscarAutorPorNombre(){
        System.out.println("Escriba el nombre del autor que desea buscar: ");
        var nombre = teclado.nextLine();
        Optional<Autores> autorOptional = autoresRepositorio.findByNombre(nombre);
        if(autorOptional.isPresent()){
            System.out.println(autorOptional.get());
        } else {
            System.out.println("No se encontró el autor");
        }
    }
}
