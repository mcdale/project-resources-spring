package com.example.project.risk.domain.api;

import java.io.Serializable;
import java.time.Instant;

import lombok.Value;

@SuppressWarnings("serial")
@Value
public class RiskCreated implements Serializable {
	private String identifier;
	private String name;
	private Instant created;
}
