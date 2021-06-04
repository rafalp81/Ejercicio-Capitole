package com.capitole.ejercicio.restzara;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class RestzaraApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestzaraApplication.class, args);
	}

}
