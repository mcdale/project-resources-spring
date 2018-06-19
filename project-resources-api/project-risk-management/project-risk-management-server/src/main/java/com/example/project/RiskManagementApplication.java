package com.example.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.project.risk.starter.EnableRiskManagement;

@EnableAutoConfiguration
@EnableRiskManagement
@SpringBootApplication
public class RiskManagementApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(RiskManagementApplication.class, args);
	}
	
	
	
}
