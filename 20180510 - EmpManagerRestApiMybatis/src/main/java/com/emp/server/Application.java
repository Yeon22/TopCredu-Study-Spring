package com.emp.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.emp.server")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
