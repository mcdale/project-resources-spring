package com.example.project.integration.domain.api;

import java.io.Serializable;
import java.time.Instant;

import lombok.Value;

@SuppressWarnings("serial")
@Value
public class ProjectCreated implements Serializable {
	private String identifier;
	private String name;
	private Instant created;
}
