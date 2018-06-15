package com.example.rest.resources;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.axonframework.common.DateTimeUtils;

import com.example.core.Identifiable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiResource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@JsonApiResource(type="risks")
@NoArgsConstructor
public class RiskResource implements Identifiable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("description")
	@JsonPropertyDescription("Optional additional desription for the information element.")
	private String desc;
	
	@Id
	@JsonApiId
	@JsonPropertyDescription("The lifetime immutable identifier for an instance of a domain aggregate.")
	private String identifier;
	
	@JsonIgnore
	private Instant lastChange;
	
	@JsonProperty("title")
	@JsonPropertyDescription("The human-readable name for the element")
	private String longName;
	
	@JsonProperty("last-change")
	@JsonPropertyDescription("The date and time of the last change of the information element. This includes the creation of the element.")
	public String getLastChangeAsString() {
		return DateTimeUtils.formatInstant(lastChange);
	}
	
}
