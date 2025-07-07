package Verifica.CarrosFIPE;

import Verifica.CarrosFIPE.Principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public abstract class CarrosFipeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CarrosFipeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();

		principal.exibeFIPE();
	}
}
