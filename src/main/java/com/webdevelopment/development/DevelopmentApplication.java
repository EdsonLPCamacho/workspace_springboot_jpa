package com.webdevelopment.development;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.webdevelopment.development")
public class DevelopmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevelopmentApplication.class, args);
	}

}
