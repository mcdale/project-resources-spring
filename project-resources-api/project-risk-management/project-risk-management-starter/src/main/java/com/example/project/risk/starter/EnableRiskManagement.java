package com.example.project.risk.starter;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"org.axonframework",
	"com.example.project.risk.domain",
	"com.example.project.risk.data.repository", 
	"com.example.project.risk.data.model",
	"com.example.project.risk.resource",
	"com.example.project.risk.resource.repository"})
@EnableAutoConfiguration
@EnableJpaRepositories({"com.example.project.risk.data.repository"})
@EntityScan({"com.example.project.risk.data.model"})
public @interface EnableRiskManagement {

}
