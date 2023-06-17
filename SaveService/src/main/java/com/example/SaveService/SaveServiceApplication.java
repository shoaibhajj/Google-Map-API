package com.example.SaveService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableEurekaClient
public class SaveServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaveServiceApplication.class, args);
	}

}
