package com.citasapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class AppCitasApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppCitasApplication.class, args);
	}

}
