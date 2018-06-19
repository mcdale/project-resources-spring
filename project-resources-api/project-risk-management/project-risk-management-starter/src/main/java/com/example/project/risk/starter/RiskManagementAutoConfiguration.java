package com.example.project.risk.starter;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan({"org.axonframework",
	"com.example.project.risk.domain",
	"com.example.project.risk.data.repository", 
	"com.example.project.risk.data.model",
	"com.example.risk.resource",
	"com.example.risk.resource.repository",
	"com.example.risk.resource.repository.impl"})
@Configuration
public class RiskManagementAutoConfiguration {

}
