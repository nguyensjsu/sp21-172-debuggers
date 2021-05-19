package com.example.starbucksapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.example.StarbucksModel")
@EnableJpaRepositories(basePackages = {"com.example.StarbucksModel", "com.example.StarbucksRepository"})
public class StarbucksApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarbucksApiApplication.class, args);
	}

}
