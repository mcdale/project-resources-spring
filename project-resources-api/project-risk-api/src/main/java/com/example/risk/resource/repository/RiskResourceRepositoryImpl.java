package com.example.risk.resource.repository;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.common.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.core.commands.CreateRisk;
import com.example.core.commands.DeleteRisk;
import com.example.risk.data.model.RiskEntity;
import com.example.risk.data.repository.RiskEntityRepository;
import com.example.risk.resource.RiskResource;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;

public class RiskResourceRepositoryImpl extends ResourceRepositoryBase<RiskResource, String>
		implements RiskResourceRepository {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private RiskEntityRepository repository;

	protected RiskResourceRepositoryImpl() {
		super(RiskResource.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public RiskResourceList findAll(QuerySpec querySpec) {
		RiskResourceList list = new RiskResourceList();
		list.setMeta(meta(querySpec));
		
		List<RiskResource> resources = new ArrayList<RiskResource>();
		for(RiskEntity entity: repository.findAll()) {
			resources.add(RiskResource.fromEntity(entity));	
		}
		querySpec.apply(resources, list);
		
		return list;
	}
	
	private RiskResourceListMeta meta(QuerySpec querySpec) {
		RiskResourceListMeta meta = new RiskResourceListMeta();
		meta.setTotalResourceCount(repository.count());
		
		return meta;
	}

	@Override
	public RiskResource findOne(String id, QuerySpec querySpec) {
		return RiskResource.fromEntity(repository.findOne(id));
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
		resource.setLastChange(DateTimeUtils.formatInstant(command.getLastChange()));
		
		commandGateway.send(command);
		
		return resource;
	}

	@Override
	public void delete(String id) {
		commandGateway.send(new DeleteRisk(id));
	}

}
