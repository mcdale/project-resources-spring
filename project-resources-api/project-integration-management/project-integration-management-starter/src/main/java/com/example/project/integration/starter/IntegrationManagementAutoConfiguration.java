package com.example.project.integration.starter;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import io.katharsis.spring.boot.v3.KatharsisConfigV3;


@Configuration
@Import({KatharsisConfigV3.class})
public class IntegrationManagementAutoConfiguration {

}
