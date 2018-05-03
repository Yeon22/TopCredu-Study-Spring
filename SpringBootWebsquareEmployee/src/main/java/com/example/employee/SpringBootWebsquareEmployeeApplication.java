package com.example.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.employee")
public class SpringBootWebsquareEmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebsquareEmployeeApplication.class, args);
	}
}
