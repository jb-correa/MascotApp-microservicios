package com.mascotapp.mascotapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"my_package.infrastructure.mongo"})
public class MascotappApplication {

	public static void main(String[] args) {

		SpringApplication.run(MascotappApplication.class, args);

	}

}
