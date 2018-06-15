package com.example.core.events;

import java.time.Instant;

import com.example.core.Identifiable;

import lombok.Value;

@Value
public class RiskCreated implements Identifiable {

	private static final long serialVersionUID = 1L;
	String desc;
	String identifier;
	Instant lastChange;
	String longName;
}
