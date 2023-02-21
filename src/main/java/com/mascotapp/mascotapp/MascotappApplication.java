package com.mascotapp.mascotapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"my_package.infrastructure.mongo"})
public class MascotappApplication {

	public static void main(String[] args) {

		SpringApplication.run(MascotappApplication.class, args);

	}

}
