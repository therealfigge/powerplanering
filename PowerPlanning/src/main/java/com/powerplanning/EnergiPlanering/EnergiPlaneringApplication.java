package com.powerplanning.EnergiPlanering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EnergiPlaneringApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnergiPlaneringApplication.class, args);
	}

}
