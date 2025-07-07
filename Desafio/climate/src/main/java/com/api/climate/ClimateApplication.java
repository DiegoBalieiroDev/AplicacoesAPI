package com.api.climate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClimateApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ClimateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var menu = new main();
		menu.weatherInfo();
	}
}
