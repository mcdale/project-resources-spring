package com.example.core.commands;

import java.time.Instant;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import com.example.core.Identifiable;
import com.example.core.utils.IdGenerator;

import lombok.Value;

@Value
public class CreateRisk implements Identifiable {

	private static final long serialVersionUID = 1L;
	
	public static CreateRisk withValues(String longName,String desc) {
		return new CreateRisk(desc, IdGenerator.generateId(), Instant.now(), longName);
	}
	
	String desc;
	@TargetAggregateIdentifier
	String identifier;
	Instant lastChange;
	String longName;
	
	
}
