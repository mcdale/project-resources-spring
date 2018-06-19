package com.example.project.risk.resource;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiResource;
import lombok.Data;

@Data
@JsonApiResource(type="risks")
public class RiskResource {
	@JsonApiId
	private String id;
	
	private String title;
	
	private String lastChange;
}
