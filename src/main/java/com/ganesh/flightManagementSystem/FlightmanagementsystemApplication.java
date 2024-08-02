package com.ganesh.flightManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ganesh.flightManagementSystem"})
public class FlightmanagementsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightmanagementsystemApplication.class, args);
	}

}