package com.example.rest.resources;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.core.commands.CreateRisk;
import com.example.core.commands.DeleteRisk;
import com.example.core.events.RiskCreated;
import com.example.core.events.RiskDeleted;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;

@Component
public class RiskResourceHandlerImpl extends ResourceRepositoryBase<RiskResource, String>
		implements RiskResourceHandler {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private RiskResourceRepository repository;

	protected RiskResourceHandlerImpl() {
		super(RiskResource.class);
		// TODO Auto-generated constructor stub
	}

	@EventHandler
	void on(RiskCreated event) {
		RiskResource entity = new RiskResource(event.getDesc(),event.getIdentifier(), event.getLastChange(), event.getLongName());
		repository.save(entity);
	}

	@EventHandler
	void on(RiskDeleted event) {
		RiskResource entity = repository.findOne(event.getIdentifier());
		repository.delete(entity);
	}

	@Override
	public RiskResourceList findAll(QuerySpec querySpec) {
		RiskResourceList list = new RiskResourceList();
		list.setMeta(meta(querySpec));
		
		querySpec.apply(repository.findAll(), list);
		return list;
	}
	
	private RiskResourceListMeta meta(QuerySpec querySpec) {
		RiskResourceListMeta meta = new RiskResourceListMeta();
		meta.setTotalResourceCount(repository.count());
		
		return meta;
	}

	@Override
	public RiskResource findOne(String id, QuerySpec querySpec) {
		return repository.findOne(id);
	}

	@Override
	public <S extends RiskResource> S save(S resource) {
		if(hasIdentifier(resource))
			return resource;
		
		return create(resource);
	}

	private <S extends RiskResource> boolean hasIdentifier(S resource) {
		return !(resource.getIdentifier().isEmpty());
	}

	@Override
	public <S extends RiskResource> S create(S resource) {
		CreateRisk command = CreateRisk.withValues(resource.getLongName(),resource.getDesc());
		resource.setIdentifier(command.getIdentifier());
		resource.setLastChange(command.getLastChange());
		
		commandGateway.send(command);
		
		return resource;
	}

	@Override
	public void delete(String id) {
		commandGateway.send(new DeleteRisk(id));
	}

}
