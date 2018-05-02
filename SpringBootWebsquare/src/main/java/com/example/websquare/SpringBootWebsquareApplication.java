package com.example.websquare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.websquare"})
public class SpringBootWebsquareApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebsquareApplication.class, args);
	}
}
