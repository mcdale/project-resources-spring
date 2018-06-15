package com.example.core.commands;

import java.io.Serializable;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import lombok.Value;

@Value
public class DeleteRisk implements Serializable {

	private static final long serialVersionUID = 1L;
	@TargetAggregateIdentifier
	String identifier;
}
