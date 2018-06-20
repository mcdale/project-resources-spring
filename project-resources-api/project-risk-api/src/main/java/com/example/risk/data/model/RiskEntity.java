package com.example.risk.data.model;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.axonframework.common.DateTimeUtils;

import lombok.Data;

@Data
@Entity
public class RiskEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	public static RiskEntity create(String identifier, String longName, String desc, Instant lastChange) {
		RiskEntity entity = new RiskEntity();
		entity.setDescription(desc);
		entity.setIdentifier(identifier);
		entity.setLastModified(DateTimeUtils.formatInstant(lastChange));
		entity.setTitle(longName);
		return entity;
	}
	
	private String description;
	
	@Id
	private String identifier;

	private String lastModified;
	
	private String title;
}
