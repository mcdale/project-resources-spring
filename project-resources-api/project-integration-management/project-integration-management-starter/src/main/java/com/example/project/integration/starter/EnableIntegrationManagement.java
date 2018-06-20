package com.example.project.integration.starter;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"org.axonframework",
	"com.example.project.integration.domain",
	"com.example.project.integration.data.repository", 
	"com.example.project.integration.data.model",
	"com.example.project.integration.resource",
	"com.example.project.integration.resource.repository"})
@EnableAutoConfiguration
@EnableJpaRepositories({"com.example.project.integration.data.repository"})
@EntityScan({"com.example.project.integration.data.model"})
public @interface EnableIntegrationManagement {

}
