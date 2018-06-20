package com.example.project;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.integration.starter.EnableIntegrationManagement;

import io.katharsis.resource.registry.RegistryEntry;
import io.katharsis.resource.registry.ResourceRegistry;


@EnableAutoConfiguration
@EnableIntegrationManagement
@RestController
@SpringBootApplication
public class IntegrationManagementApplication {

	@Autowired
	private ResourceRegistry resourceRegistry;
	
	@GetMapping("/resources-info")
	public Map<?, ?> getResources() {
		Map<String, String> result = new HashMap<>();
		// Add all resources (i.e. Project and Task)
		for (RegistryEntry entry : resourceRegistry.getResources()) {
			result.put(entry.getResourceInformation().getResourceType(), resourceRegistry.getResourceUrl(entry.getResourceInformation()));
		}
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(IntegrationManagementApplication.class, args);
	}
	
	
	
}
