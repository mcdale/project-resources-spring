package com.example.project.risk.domain.commands;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import lombok.Value;

@SuppressWarnings("serial")
@Value
public class CreateRisk implements Serializable {
	
	public static CreateRisk withValues(String name) {
		return new CreateRisk(UUID.randomUUID().toString(),name,Instant.now());
	}
	
	@TargetAggregateIdentifier
	private String identifier;
	private String name;
	private Instant created;
}
