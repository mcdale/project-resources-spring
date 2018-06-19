package com.example.risk.resource;

import java.io.Serializable;

import com.example.risk.data.model.RiskEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonApiResource(type="risks")
@NoArgsConstructor
public class RiskResource implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public static RiskResource fromEntity(RiskEntity entity) {
		RiskResource resource = new RiskResource();
		resource.setIdentifier(entity.getIdentifier());
		resource.setDesc(entity.getDescription());
		resource.setLastChange(entity.getLastModified());
		resource.setLongName(entity.getTitle());
		
		return resource;
	}
	
	@JsonProperty("description")
	@JsonPropertyDescription("Optional additional desription for the information element.")
	private String desc;
	
	@JsonApiId
	@JsonPropertyDescription("The lifetime immutable identifier for an instance of a domain aggregate.")
	private String identifier;
	
	@JsonProperty("last-change")
	@JsonPropertyDescription("The date and time of the last change of the information element. This includes the creation of the element.")
	private String lastChange;
	
	@JsonProperty("title")
	@JsonPropertyDescription("The human-readable name for the element")
	private String longName;
	
	
	
}
