package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PlaneProjectApplication {

	public static void main(String[] args) {
	
		ApplicationContext context = SpringApplication.run(PlaneProjectApplication.class, args);
		System.out.println("SERVICE: " + context.getBean(PlaneService.class));
		System.out.println("CONTROLLER: " + context.getBean(PlaneController.class));
	}

}
