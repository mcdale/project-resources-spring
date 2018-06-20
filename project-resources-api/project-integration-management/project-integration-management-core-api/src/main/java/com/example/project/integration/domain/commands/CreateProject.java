package com.example.project.integration.domain.commands;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import lombok.Value;

@SuppressWarnings("serial")
@Value
public class CreateProject implements Serializable {
	
	public static CreateProject withValues(String name) {
		return new CreateProject(UUID.randomUUID().toString(),name,Instant.now());
	}
	
	@TargetAggregateIdentifier
	private String identifier;
	private String name;
	private Instant created;
}
