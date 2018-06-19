package com.example.risk.data.model;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.core.events.RiskCreated;
import com.example.risk.data.repository.RiskEntityRepository;

@Component
public class RiskEventHandler {

	@Autowired
	private RiskEntityRepository repository;
	
	@EventHandler
	public void on(RiskCreated event) {
		repository.save(RiskEntity.create(event.getIdentifier(),event.getLongName(),event.getDesc(),event.getLastChange()));
	}
}
