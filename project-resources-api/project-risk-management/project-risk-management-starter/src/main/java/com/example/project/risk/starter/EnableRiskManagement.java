package com.example.project.risk.starter;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@EnableJpaRepositories({"com.example.project.risk.data.repository"})
@EntityScan({"com.example.project.risk.data.model"})
public @interface EnableRiskManagement {

}
