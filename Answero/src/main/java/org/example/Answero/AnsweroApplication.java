package org.example.Answero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.example.Answero.service", "org.example.Answero.modal", "org.example.Answero.controller"})
public class AnsweroApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnsweroApplication.class, args);
	}

}
