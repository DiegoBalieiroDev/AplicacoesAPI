package br.com.teste.infoPaises;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InfoPaisesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(InfoPaisesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main();

		main.countryInfo();
	}
}
