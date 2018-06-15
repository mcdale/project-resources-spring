package com.example.core.events;

import java.io.Serializable;

import lombok.Value;

@Value
public class RiskDeleted implements Serializable {

	private static final long serialVersionUID = 1L;
	String identifier;
	
}
