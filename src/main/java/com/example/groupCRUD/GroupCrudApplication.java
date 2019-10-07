package com.example.groupCRUD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@EnableEurekaClient
public class GroupCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroupCrudApplication.class, args);
	}

}
