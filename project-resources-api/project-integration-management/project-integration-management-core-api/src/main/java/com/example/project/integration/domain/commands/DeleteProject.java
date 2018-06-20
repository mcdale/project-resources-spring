package com.example.project.integration.domain.commands;

import java.io.Serializable;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import lombok.Value;

@SuppressWarnings("serial")
@Value
public class DeleteProject implements Serializable {
	
	@TargetAggregateIdentifier
	private String identifier;
	
}
