package com.example.project.risk.domain.commands;

import java.io.Serializable;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import lombok.Value;

@SuppressWarnings("serial")
@Value
public class DeleteRisk implements Serializable {
	
	@TargetAggregateIdentifier
	private String identifier;
	
}
