package com.example.ResturantService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableJpaRepositories
@EnableEurekaClient
public class ResturantServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResturantServiceApplication.class, args);
	}


	@Bean
	public RestTemplate rest()
	{
		return new RestTemplate();
	}
}
