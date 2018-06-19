package com.example.project.risk.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRiskManagement
@SpringBootApplication
public class RiskManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(RiskManagementApplication.class, args);
	}
}
