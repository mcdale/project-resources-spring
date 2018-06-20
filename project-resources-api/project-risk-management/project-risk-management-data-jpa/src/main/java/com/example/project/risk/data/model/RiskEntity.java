package com.example.project.risk.data.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class RiskEntity {
	@Id
	private String identifier;
	
	private String name;
	
	private String description;
	
	private Instant createdDate;
	
	private Instant updatedDate;
}
