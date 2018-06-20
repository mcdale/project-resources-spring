package com.example.project.risk.domain.api;

import java.io.Serializable;

import lombok.Value;

@SuppressWarnings("serial")
@Value
public class RiskDeleted implements Serializable {
	private String identifier;
}
