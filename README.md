<h1 align="center">:books: Desafío Alura Challenge - Literalura :books: </h1>
DesafioAluraChallengeLiteralura es una aplicación de consola para gestionar libros y autores utilizando datos de la API de Gutendex. Esta aplicación permite buscar libros por título, listar libros y autores registrados, generar estadísticas de descargas, y más.

## Tabla de Contenidos

- [Descripción](#descripción)
- [Funcionalidades](#funcionalidades)
- [Tecnologías Utilizadas](#tecnologías-utilizadas)
- [Instalación](#instalación)
- [Uso](#uso)


## Descripción

Desafio Alura Challenge Literalura es una aplicación desarrollada en Java utilizando Spring Boot. Su propósito es gestionar una base de datos de libros y autores, permitiendo a los usuarios realizar diversas operaciones como buscar libros, listar autores, generar estadísticas y más. La aplicación se integra con la API de Gutendex para obtener información sobre libros y autores.

## Funcionalidades

1. **Buscar libro por Título**: Permite buscar libros por su título utilizando la API de Gutendex.
2. **Listar todos los libros registrados**: Muestra una lista de todos los libros almacenados en la base de datos.
3. **Listar Autores registrados**: Muestra una lista de todos los autores almacenados en la base de datos.
4. **Listar autores vivos en determinado año**: Muestra autores que estaban vivos en un año específico.
5. **Listar libros por idioma**: Permite listar libros filtrados por su idioma.
6. **Generar estadísticas de descargas**: Genera estadísticas relacionadas con el número de descargas de los libros.
7. **Top 10 libros más descargados**: Muestra los 10 libros más descargados.
8. **Buscar autor por nombre**: Permite buscar autores por su nombre.


## Tecnologías Utilizadas

- [Java](https://www.java.com/es/)
- [Spring Boot](https://start.spring.io/;)
- [H2 Database](https://www.postgresql.org/)
- [Gutendex API](https://gutendex.com).

## Instalación

1. Clona el repositorio:

    ```bash
    git clone https://github.com/tuUsuario/desafio-alura-challenge-literalura.git
    ```

2. Navega al directorio del proyecto:

    ```bash
    cd desafio-alura-challenge-literalura
    ```

3. Ejecuta la aplicación con Maven:

    ```bash
    mvn spring-boot:run
    ```
### Modelo Entidad Relación 
![image](https://github.com/Cristhian-Larra/Desafio-alura-Challenge-Literalura/assets/141253906/d08df930-5f79-4f5c-91e7-6002fd64b043)


## Uso
Una vez que la aplicación esté en ejecución, verás un menú en la consola:
1. **Buscar libro por Título**:
    - Ingresa `1` y presiona `Enter`.
    - Escribe el título del libro que deseas buscar y presiona `Enter`.

2. **Listar todos los libros registrados**:
    - Ingresa `2` y presiona `Enter`.
    - La aplicación mostrará una lista de todos los libros registrados.

3. **Listar Autores registrados**:
    - Ingresa `3` y presiona `Enter`.
    - La aplicación mostrará una lista de todos los autores registrados.

4. **Listar autores vivos en determinado año**:
    - Ingresa `4` y presiona `Enter`.
    - Escribe el año y presiona `Enter`.
    - La aplicación mostrará los autores que estaban vivos en ese año.

5. **Listar libros por idioma**:
    - Ingresa `5` y presiona `Enter`.
    - Escribe el código del idioma (por ejemplo, `en` para inglés) y presiona `Enter`.
    - La aplicación mostrará los libros en el idioma seleccionado.

6. **Generar estadísticas de descargas**:
    - Ingresa `6` y presiona `Enter`.
    - La aplicación generará y mostrará estadísticas de descargas de los libros.

7. **Top 10 libros más descargados**:
    - Ingresa `7` y presiona `Enter`.
    - La aplicación mostrará los 10 libros más descargados.

8. **Buscar autor por nombre**:
    - Ingresa `8` y presiona `Enter`.
    - Escribe el nombre del autor que deseas buscar y presiona `Enter`.
    - La aplicación mostrará la información del autor si está registrado.

9. **Salir**:
    - Ingresa `0` y presiona `Enter` para salir de la aplicación.
  
