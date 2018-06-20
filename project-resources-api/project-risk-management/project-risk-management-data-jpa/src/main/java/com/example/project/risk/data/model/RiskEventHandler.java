package com.example.project.risk.data.model;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.project.risk.data.repository.RiskEntityRepository;
import com.example.project.risk.domain.api.RiskCreated;
import com.example.project.risk.domain.api.RiskDeleted;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RiskEventHandler {
	
	@Autowired
	private RiskEntityRepository repository;
	
	@EventHandler
	public void handle(RiskCreated event) {
		RiskEntity entity = new RiskEntity();
		entity.setIdentifier(event.getIdentifier());
		entity.setName(event.getName());
		entity.setCreatedDate(event.getCreated());
		entity.setUpdatedDate(event.getCreated());
		
		repository.save(entity);
		
		log.debug("Handled {0}: {1}", event, entity);
	}
	
	@EventHandler
	public void handle(RiskDeleted event) {
		RiskEntity entity = repository.findOne(event.getIdentifier());
		repository.delete(entity);
		
		log.debug("Handled {0}: {1}", event, entity);
	}
}
