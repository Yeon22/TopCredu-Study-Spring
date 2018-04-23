package com.javasampleapproach.uploadfiles;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javasampleapproach.uploadfiles.storage.StorageService;

@SpringBootApplication
public class SpringBootUploadFileApplication implements CommandLineRunner {
	@Resource
	StorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootUploadFileApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		storageService.deleteAll();
		storageService.init();
	}
}
