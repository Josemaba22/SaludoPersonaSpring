package com.neoris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.neoris.saludo.controller","com.neoris.saludo.service","com.neoris.saludo.exception"})
@EntityScan("com.neoris.saludo.entity")
@EnableJpaRepositories("com.neoris.saludo.repository")
public class ActividadSaludoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActividadSaludoApplication.class, args);
	}

}
