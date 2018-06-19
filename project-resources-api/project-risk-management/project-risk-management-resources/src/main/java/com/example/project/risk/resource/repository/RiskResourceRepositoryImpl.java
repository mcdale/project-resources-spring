package com.example.project.risk.resource.repository;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.project.risk.data.model.RiskEntity;
import com.example.project.risk.data.repository.RiskEntityRepository;
import com.example.project.risk.resource.RiskResource;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;

public class RiskResourceRepositoryImpl extends ResourceRepositoryBase<RiskResource,String> implements RiskResourceRepository {
	
	@Autowired
	private RiskEntityRepository risks;
	
	public RiskResourceRepositoryImpl() {
		super(RiskResource.class);
	}

	@Override
	public RiskResourceList findAll(QuerySpec querySpec) {
		RiskResourceList list = new RiskResourceList();
		Iterable<RiskEntity> entities = getAllRisks();
		Iterable<RiskResource> resources = convert(entities);
		querySpec.apply(resources, list);
		
		return list;
	}

	private Converter<Iterable<RiskEntity>,Iterable<RiskResource>> convert()
	private Iterable<RiskEntity> getAllRisks() {
		return risks.findAll();
	}
}
