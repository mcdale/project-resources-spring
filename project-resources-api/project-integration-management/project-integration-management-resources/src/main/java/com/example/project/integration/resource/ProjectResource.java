package com.example.project.integration.resource;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiResource;
import lombok.Data;

@Data
@JsonApiResource(type="projects")
public class ProjectResource {
	@JsonApiId
	private String id;
	
	private String title;
	
	private String lastChange;
}
