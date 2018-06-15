package com.example.core.domain;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateLifecycle;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import com.example.core.commands.CreateRisk;
import com.example.core.commands.DeleteRisk;
import com.example.core.events.RiskCreated;
import com.example.core.events.RiskDeleted;

@Aggregate
public class Risk {
	@AggregateIdentifier
	private String identifier;
	
	public Risk() {
		
	}
	
	@CommandHandler
	public Risk(CreateRisk command) {
		AggregateLifecycle.apply(new RiskCreated(command.getDesc(),command.getIdentifier(),command.getLastChange(),command.getLongName()));
	}
	
	@CommandHandler
	void handle(DeleteRisk command) {
		AggregateLifecycle.apply(new RiskDeleted(command.getIdentifier()));
	}
	
	@EventSourcingHandler
	void on(RiskCreated event) {
		this.identifier = event.getIdentifier();
	}
	
	@EventSourcingHandler
	void on(RiskDeleted event) {
		AggregateLifecycle.markDeleted();
	}
	
}
