package com.example.project.integration.data.model;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.project.integration.data.repository.ProjectEntityRepository;
import com.example.project.integration.domain.api.ProjectCreated;
import com.example.project.integration.domain.api.ProjectDeleted;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ProjectEventHandler {
	
	@Autowired
	private ProjectEntityRepository repository;
	
	@EventHandler
	public void handle(ProjectCreated event) {
		ProjectEntity entity = new ProjectEntity();
		entity.setIdentifier(event.getIdentifier());
		entity.setName(event.getName());
		entity.setCreatedDate(event.getCreated());
		entity.setUpdatedDate(event.getCreated());
		
		repository.save(entity);
		
		log.debug("Handled {0}: {1}", event, entity);
	}
	
	@EventHandler
	public void handle(ProjectDeleted event) {
		ProjectEntity entity = repository.findOne(event.getIdentifier());
		repository.delete(entity);
		
		log.debug("Handled {0}: {1}", event, entity);
	}
}
