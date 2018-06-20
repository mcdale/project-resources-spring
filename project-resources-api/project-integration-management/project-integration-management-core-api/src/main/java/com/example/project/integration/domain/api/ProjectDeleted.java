package com.example.project.integration.domain.api;

import java.io.Serializable;

import lombok.Value;

@SuppressWarnings("serial")
@Value
public class ProjectDeleted implements Serializable {
	private String identifier;
}
