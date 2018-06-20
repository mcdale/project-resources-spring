package com.example.project.risk.resource.repository;

import java.util.HashMap;
import java.util.Map;

import org.axonframework.common.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.project.risk.data.model.RiskEntity;
import com.example.project.risk.data.repository.RiskEntityRepository;
import com.example.project.risk.resource.RiskResource;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;

@Component
public class RiskResourceRepositoryImpl extends ResourceRepositoryBase<RiskResource,String> implements RiskResourceRepository {
	
	@Autowired
	private RiskEntityRepository risks;
	
	public RiskResourceRepositoryImpl() {
		super(RiskResource.class);
	}

	@Override
	public RiskResourceList findAll(QuerySpec querySpec) {
		
		RiskResourceList list = new RiskResourceList();
		RiskResourceListMeta meta = new RiskResourceListMeta();
		meta.setTotalResourceCount(risks.count());
		
		RiskResourceListLinks links = new RiskResourceListLinks();
		
		Iterable<RiskEntity> entities = getAllRisks();
		
		Iterable<RiskResource> resources = convert(entities);
		
		list.setMeta(meta);
		
		list.setLinks(links);
		
		querySpec.apply(resources, list);
		
		return list;
	}

	
	private Iterable<RiskResource> convert(Iterable<RiskEntity> entities) {
		
		Map<String, RiskResource> resources = new HashMap<String, RiskResource>();
		
		for(RiskEntity entity: entities) {
			RiskResource resource = new RiskResource();
			resource.setId(entity.getIdentifier());
			resource.setLastChange(DateTimeUtils.formatInstant(entity.getUpdatedDate()));
			resource.setTitle(entity.getName());
			
			resources.put(resource.getId(), resource);
		}
		
		return resources.values();
	}

	private Iterable<RiskEntity> getAllRisks() {
		return risks.findAll();
	}
}
