package com.aluracursos.Desafio_alura_Challenge.Literalura;

import com.aluracursos.Desafio_alura_Challenge.Literalura.principal.Principal;
import com.aluracursos.Desafio_alura_Challenge.Literalura.repository.AutoresRepository;
import com.aluracursos.Desafio_alura_Challenge.Literalura.repository.LibroRepository;
import com.aluracursos.Desafio_alura_Challenge.Literalura.service.LibrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioAluraChallengeLiteraluraApplication implements CommandLineRunner  {
	@Autowired
	private LibroRepository libroRepository;
	@Autowired
	private AutoresRepository autoresRepository;
	public static void main(String[] args) {
		SpringApplication.run(DesafioAluraChallengeLiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Bienvenido a la aplicación de Screenmatch");
		Principal principal = new Principal(libroRepository, autoresRepository);
		principal.mostrarMenu();
	}
}
