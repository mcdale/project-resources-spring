package com.example.rest.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.katharsis.resource.registry.RegistryEntry;
import io.katharsis.resource.registry.ResourceRegistry;
import io.katharsis.spring.boot.v3.KatharsisConfigV3;
import lombok.RequiredArgsConstructor;

@ComponentScan({"com.example.risk.data.model","com.example.risk.data.event","com.example.risk.data.repository","com.example.risk.rest.resource","com.example.risk.rest.resource.repository"})
@Import({KatharsisConfigV3.class})
@RestController
@RequiredArgsConstructor
public class KatharsisController {
	
	private final ResourceRegistry resourceRegistry;
	
	@GetMapping("/resources-info")
	public Map<?, ?> getResources() {
		Map<String, String> result = new HashMap<>();
		// Add all resources (i.e. Project and Task)
		for (RegistryEntry entry : resourceRegistry.getResources()) {
			result.put(entry.getResourceInformation().getResourceType(), resourceRegistry.getResourceUrl(entry.getResourceInformation()));
		}
		return result;
	}
}
